package br.com.anotaai.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.anotaai.dto.request.UsuarioRequest;
import br.com.anotaai.entity.Usuario;
import br.com.anotaai.enums.Roles;
import br.com.anotaai.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public UsuarioService(UsuarioRepository usuarioRepository,PasswordEncoder passwordEncoder ) {
        this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }


    public Usuario save(UsuarioRequest usuarioRequest) {
    	if (usuarioRepository.findByEmail(usuarioRequest.email()) != null) {
            throw new RuntimeException("Email já cadastrado");
        }
    	Usuario usuario = new Usuario();
    	usuario.setNome(usuarioRequest.nome());
    	usuario.setEmail(usuarioRequest.email());
    	usuario.setPassword(
    	        passwordEncoder.encode(usuarioRequest.senha()));
    	usuario.setRole(usuarioRequest.role());
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
