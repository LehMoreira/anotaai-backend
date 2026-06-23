package br.com.anotaai.dto.request;

import jakarta.validation.constraints.NotNull;

public class CriarSecaoRequest{


    @NotNull(message = "tipo notificaçao nao pode ser nulo!")
    private String nome;



    public CriarSecaoRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
