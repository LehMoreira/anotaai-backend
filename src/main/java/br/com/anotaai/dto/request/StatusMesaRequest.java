package br.com.anotaai.dto.request;

import br.com.anotaai.enums.StatusMesa;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class StatusMesaRequest {

    @NotNull(message = "O status e obrigatorio!")
    private StatusMesa statusMesa;

    public StatusMesaRequest(StatusMesa statusMesa) {

    }

    public StatusMesa getStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(StatusMesa statusMesa) {
        this.statusMesa = statusMesa;
    }
}
