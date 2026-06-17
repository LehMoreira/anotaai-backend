package br.com.anotaai.dto.request;


import br.com.anotaai.enums.StatusPedido;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class StatusPedidoRequest {

    @NotNull(message = "O status e obrigatorio!")
    private StatusPedido statusPedido;

    public StatusPedidoRequest(StatusPedido statusPedido) {

    }


    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
