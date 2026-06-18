package br.com.anotaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anotaai.entity.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long>{

}
