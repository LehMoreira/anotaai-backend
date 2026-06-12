package br.com.anotaai.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.anotaai.entity.RefreshToken;
import br.com.anotaai.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final RefreshTokenRepository repository = null;

    @Value("${security.jwt.refresh-expiration-minutes}")
    private long refreshExpiration;


    public RefreshToken create(Long userId) {
        RefreshToken token = new RefreshToken();
        token.setId(userId);
        token.setToken(UUID.randomUUID().toString());
        token.setDateExpiry(
                LocalDateTime.now().plusMinutes(refreshExpiration));
        token.setRevoke(false);
        return repository.save(token);
    }


    public RefreshToken validate(String token) {

        RefreshToken refreshToken = repository.findByToken(token)
                .orElseThrow(() ->
                        new RuntimeException("Refresh token inválido"));

        if (refreshToken.isRevoke()) {
            throw new RuntimeException("Refresh token revogado");
        }

        if (refreshToken.getDateExpiry().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Refresh token expirado");
        }

        return refreshToken;
    }

}