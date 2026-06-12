package br.com.anotaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anotaai.entities.HistoricoLogin;
import br.com.anotaai.entities.Usuario;

public interface HistoricoLoginRepository extends JpaRepository<HistoricoLogin, Long>{

}
