package br.com.anotaai.dto.response;


import br.com.anotaai.enums.StatusMesa;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


public class MesaResponse {

    private Long id;

    private Long numeroMesa;

    private int capacidade;

    private StatusMesa statusMesa;

    public MesaResponse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
