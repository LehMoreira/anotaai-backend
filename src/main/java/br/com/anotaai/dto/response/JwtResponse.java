package br.com.anotaai.dto.response;

public record JwtResponse(    
		Long id,
		String accessToken, 
		String refreshTokenToken, 
		String role) {

}
