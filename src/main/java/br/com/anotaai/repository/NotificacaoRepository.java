package br.com.anotaai.repository;

import br.com.anotaai.entity.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

     List<Notificacao> findByUsuario_Login(String login);
}
