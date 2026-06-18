package br.com.anotaai.repository;

import br.com.anotaai.entity.Mesa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Long> {

	Optional<Mesa> findByNumeroMesa(Integer numeroMesa);

}
