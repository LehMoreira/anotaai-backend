package br.com.anotaai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anotaai.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);

}
