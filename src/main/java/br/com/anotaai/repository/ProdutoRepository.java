package br.com.anotaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anotaai.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
