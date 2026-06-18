package br.com.anotaai.dto.request;

import java.util.List;

public record PedidoRequest(
		Long comandaId,
        Long usuarioId,
        String observacao,
        List<ItemPedidoRequest> itens) {

}
