package br.com.anotaai.dto;

public record RegisterRequest(
		
		String login,
        String email,
        String senha) {}
