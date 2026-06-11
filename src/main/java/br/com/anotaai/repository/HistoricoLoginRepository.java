package br.com.anotaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anotaai.models.HistoricoLogin;
import br.com.anotaai.models.Usuario;

public interface HistoricoLoginRepository extends JpaRepository<HistoricoLogin, Long>{

}
