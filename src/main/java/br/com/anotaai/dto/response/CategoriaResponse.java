package br.com.anotaai.dto.response;


import jakarta.validation.constraints.NotNull;

public class CategoriaResponse {


    private Long id;

    @NotNull(message = "nome nao pode ser nulo!")
    private String nome;

    public CategoriaResponse() {

    }

    public CategoriaResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
