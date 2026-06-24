package br.com.anotaai.dto.request;

public record RegisterRequest(
		
		String nome,
        String email,
        String senha) {}
