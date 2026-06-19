package br.com.anotaai.dto.response;

import br.com.anotaai.enums.StatusMesa;

public class AtualizarMesaResponse {

    private Long numeroMesa;

    private int capacidade;

    public AtualizarMesaResponse(Long numeroMesa, int capacidade) {
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
    }

    public Long getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Long numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
