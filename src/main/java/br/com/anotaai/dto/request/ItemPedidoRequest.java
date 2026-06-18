package br.com.anotaai.dto.request;

import java.math.BigDecimal;

import br.com.anotaai.enums.StatusItemPedido;

public record ItemPedidoRequest(
		int quantidade, 
		Long idProduto)
		 {

}
