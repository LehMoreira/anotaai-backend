package br.com.anotaai.dto.request;



import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.net.URI;

public class CriarProdutoRequest {


    @NotNull(message = "nome nao pode ser nulo!")
    private String nome;

    private String descricao;

    @NotNull(message = "Preço nao pode ser nulo!")
    private BigDecimal preco;


    private URI imagemURL;

    @NotNull(message = "Categoria nao pode ser nula!")
    private Long categoria_id;

    public CriarProdutoRequest(String nome, String descricao, BigDecimal preco, URI imagemURL, Long categoria_id) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagemURL = imagemURL;
        this.categoria_id = categoria_id;
    }

    public CriarProdutoRequest() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public URI getImagemURL() {
        return imagemURL;
    }

    public void setImagemURL(URI imagemURL) {
        this.imagemURL = imagemURL;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }
}
