package br.com.anotaai.repository;

import br.com.anotaai.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria , Long> {
}
