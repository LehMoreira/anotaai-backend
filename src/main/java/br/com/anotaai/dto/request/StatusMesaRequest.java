package br.com.anotaai.dto.request;

import br.com.anotaai.enums.StatusMesa;
import jakarta.validation.constraints.NotNull;



public class StatusMesaRequest {

    @NotNull(message = "O status e obrigatorio!")
    private StatusMesa statusMesa;

    public StatusMesaRequest() {

    }

    public StatusMesa getStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(StatusMesa statusMesa) {
        this.statusMesa = statusMesa;
    }
}
