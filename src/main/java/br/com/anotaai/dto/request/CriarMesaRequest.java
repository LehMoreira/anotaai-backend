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
    private Secao secao;


    public CriarMesaRequest(Long numeroMesa, int capacidade, StatusMesa statusMesa, Secao secao) {
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
        this.statusMesa = statusMesa;
        this.secao = secao;
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

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }
}
