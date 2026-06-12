package br.com.anotaai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anotaai.models.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
	Optional<RefreshToken> findByToken(String token);
}
