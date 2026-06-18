package br.com.anotaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anotaai.entity.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long>{

}
