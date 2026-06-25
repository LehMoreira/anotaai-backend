package br.com.anotaai.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import br.com.anotaai.enums.StatusPedido;

public record PedidoResponse(
		Long id,
        LocalDateTime dataHora,
        String observacao,
        StatusPedido statusPedido,
        Long numeroMesa,
        String nomeUsuario,
        List<ItemPedidoResponse> itens) {

}
