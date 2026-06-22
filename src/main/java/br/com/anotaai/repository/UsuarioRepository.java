package br.com.anotaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anotaai.entity.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findByEmail(String email);
	Usuario findByLogin(String login);



}
