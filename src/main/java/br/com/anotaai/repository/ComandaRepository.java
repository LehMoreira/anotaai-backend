package br.com.anotaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anotaai.entity.Comanda;
import br.com.anotaai.enums.StatusComanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long>{
	Comanda findByMesaNumeroMesaAndStatus(
	        Integer numeroMesa,
	        StatusComanda status);
}
