package br.com.anotaai.dto.response;

import java.math.BigDecimal;
import java.net.URI;

public record ProdutoResponse(
 Long id,
 String nome,
 String descricao,
 BigDecimal preco,
 Boolean disponivel,
 URI imagemURL) {

}
