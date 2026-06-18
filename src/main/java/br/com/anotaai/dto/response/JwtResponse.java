package br.com.anotaai.dto.response;

public record JwtResponse(String accessToken, String refreshTokenToken, String role) {

}
