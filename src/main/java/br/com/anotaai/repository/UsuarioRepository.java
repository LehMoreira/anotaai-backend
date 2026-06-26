package br.com.anotaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anotaai.entity.Usuario;
import br.com.anotaai.enums.Roles;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findByEmail(String email);


}
