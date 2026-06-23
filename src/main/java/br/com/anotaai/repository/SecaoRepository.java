package br.com.anotaai.repository;

import br.com.anotaai.dto.response.SecaoResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anotaai.entity.Secao;

import java.util.List;

public interface SecaoRepository extends JpaRepository<Secao, Long>{

}
