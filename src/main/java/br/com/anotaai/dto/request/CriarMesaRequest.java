package br.com.anotaai.dto.request;


import br.com.anotaai.enums.StatusMesa;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



public class CriarMesaRequest {

    @NotNull(message = "O numero de mesa é obrigatorio!")
    private Long numeroMesa;

    @NotNull(message = "A capacidade é obrigatoria!")
    private int capacidade;

    @NotNull(message = "O status da mesa é obrigatorio!")
    private StatusMesa statusMesa;

    public CriarMesaRequest(Long numeroMesa, int capacidade, StatusMesa statusMesa) {
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
        this.statusMesa = statusMesa;
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
