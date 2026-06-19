package br.com.anotaai.dto.request;

import br.com.anotaai.entity.Comanda;
import br.com.anotaai.enums.FormaPagamento;
import br.com.anotaai.enums.StatusPagamento;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CriarPagamentoRequest {


    @NotNull(message = "data e hora nao pode ser nulo")
    private LocalDateTime dataHora;

    @NotNull(message = "forma de pagamento nao pode ser nulo")
    private FormaPagamento formaPagamento;

    @NotNull(message = "status do pagamento nao pode ser nulo")
    private StatusPagamento statusPagamento;

    @NotNull(message = "valor nao pode ser nulo")
    private Long comanda_id;

    public CriarPagamentoRequest() {

    }


    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Long getComanda_id() {
        return comanda_id;
    }

    public void setComanda_id(Long comanda_id) {
        this.comanda_id = comanda_id;
    }
}
