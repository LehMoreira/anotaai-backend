package br.com.anotaai.dto.request;

import br.com.anotaai.entity.Secao;
import br.com.anotaai.enums.StatusMesa;
import jakarta.validation.constraints.NotNull;


public class CriarMesaRequest {

    @NotNull(message = "O numero de mesa é obrigatorio!")
    private Long numeroMesa;

    @NotNull(message = "A capacidade é obrigatoria!")
    private int capacidade;

    @NotNull(message = "O status da mesa é obrigatorio!")
    private StatusMesa statusMesa;

    @NotNull(message = "a sessao tem que existir!!")
    private Long secao_id;


    public CriarMesaRequest(Long numeroMesa, int capacidade, StatusMesa statusMesa, Long secao_id) {
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
        this.statusMesa = statusMesa;
        this.secao_id = secao_id;
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

    public StatusMesa getStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(StatusMesa statusMesa) {
        this.statusMesa = statusMesa;
    }

    public Long getSecao_id() {
        return secao_id;
    }

    public void setSecao_id(Long secao_id) {
        this.secao_id = secao_id;
    }
}
