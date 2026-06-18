package br.com.anotaai.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.anotaai.enums.StatusComanda;

public record ComandaResponse(
		Long id,
        LocalDate dataAbertura,
        BigDecimal valorTotal,
        StatusComanda status,
        Long mesaId) {

}
