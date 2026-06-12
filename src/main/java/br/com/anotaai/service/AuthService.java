package br.com.anotaai.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.anotaai.dto.JwtResponse;
import br.com.anotaai.dto.LoginRequest;
import br.com.anotaai.dto.RefreshTokenRequest;
import br.com.anotaai.dto.RegisterRequest;
import br.com.anotaai.entity.RefreshToken;
import br.com.anotaai.entity.Usuario;
import br.com.anotaai.repository.UsuarioRepository;
import br.com.anotaai.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final AuthenticationManager authenticationManager = null;
    private final JwtService jwtService = new JwtService();
    private final RefreshTokenService refreshTokenService = new RefreshTokenService();
    private final HistoricoLoginService loginHistoryService = new HistoricoLoginService();
    private final UsuarioRepository userRepository = null;
    private final PasswordEncoder passwordEncoder = null;


    public JwtResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.login(), request.password()));

        CustomUserDetails user =
                (CustomUserDetails) authentication.getPrincipal();

        String accessToken = jwtService.generateToken(user);
        RefreshToken refreshToken =
                refreshTokenService.create(user.getId());

        loginHistoryService.save(user, accessToken);

        return new JwtResponse(accessToken, refreshToken.getToken());
    }

    public void register(RegisterRequest request) {

        if (userRepository.findByEmail(request.email()) != null) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario user = new Usuario();
        user.setLogin(request.login());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.senha()));
        userRepository.save(user);
    }

    public JwtResponse refreshToken(RefreshTokenRequest request) {

        RefreshToken refreshToken =
                refreshTokenService.validate(request.refreshToken());

        Usuario user = userRepository.findById(refreshToken.getUserId()).orElse(null);

        CustomUserDetails userDetails = new CustomUserDetails(user);

        String newAccessToken = jwtService.generateToken(userDetails);

        return new JwtResponse(
                newAccessToken,
                refreshToken.getToken()
        );
    }


}
