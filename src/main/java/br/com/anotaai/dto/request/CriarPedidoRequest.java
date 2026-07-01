package br.com.anotaai.dto.request;

import java.util.List;

public record CriarPedidoRequest(
		Long comandaId,
        Long usuarioId,
        Long mesaId,
        String observacao,
        List<ItemPedidoCriacaoRequest> itens) {

}
