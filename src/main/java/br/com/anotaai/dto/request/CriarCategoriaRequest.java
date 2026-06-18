package br.com.anotaai.dto.request;

public class CriarCategoriaRequest {

    private String nome;

    public CriarCategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
