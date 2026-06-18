package br.com.anotaai.dto.request;

public record RegisterRequest(
		
		String login,
        String email,
        String senha) {}
