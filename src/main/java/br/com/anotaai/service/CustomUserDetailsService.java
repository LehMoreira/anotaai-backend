package br.com.anotaai.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.anotaai.entity.Usuario;
import br.com.anotaai.security.*;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioService usuarioService;
    


    public CustomUserDetailsService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}



	@Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findByLogin(login);
        if (usuario == null) {
           throw  new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(usuario);
    }
}
