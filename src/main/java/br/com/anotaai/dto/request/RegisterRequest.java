package br.com.anotaai.dto.request;

import br.com.anotaai.enums.Roles;

public record RegisterRequest(
		
		String nome,
        String email,
        String senha,
        Roles role) {}
