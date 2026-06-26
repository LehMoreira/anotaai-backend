package br.com.anotaai.dto.request;

import br.com.anotaai.enums.Roles;

public record UsuarioRequest(
		String nome,
		String email,
		String senha,
		Roles role
		) {}
