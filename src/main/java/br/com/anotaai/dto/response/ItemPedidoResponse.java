package br.com.anotaai.dto.response;

import java.math.BigDecimal;

import br.com.anotaai.enums.StatusItemPedido;

public record ItemPedidoResponse(
		Long id, 
		int quantidade, 
		BigDecimal precoUnitario, 
		StatusItemPedido status, 
		String nomeProduto, 
		Long idPedido) {

	

}
