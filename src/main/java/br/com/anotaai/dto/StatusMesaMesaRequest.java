package br.com.anotaai.dto;

import br.com.anotaai.enums.StatusMesa;
import jakarta.validation.constraints.NotNull;

public class StatusMesaMesaRequest {

    @NotNull(message = "O status e obrigatorio!")
    private StatusMesa statusMesa;
    
	public StatusMesaMesaRequest() {}

	public StatusMesa getStatusMesa() {
		return statusMesa;
	}

	public void setStatusMesa(StatusMesa statusMesa) {
		this.statusMesa = statusMesa;
	}
    
    
}
