package br.com.anotaai.dto.response;



import br.com.anotaai.enums.FormaPagamento;
import br.com.anotaai.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagamentoResponse {

    private BigDecimal valor;

    private LocalDateTime dataHora;

    private FormaPagamento formaPagamento;

    private StatusPagamento statusPagamento;

    private Long comanda_id ;

    public PagamentoResponse(BigDecimal valor, LocalDateTime dataHora, FormaPagamento formaPagamento, StatusPagamento statusPagamento, Long comanda_id) {
        this.valor = valor;
        this.dataHora = dataHora;
        this.formaPagamento = formaPagamento;
        this.statusPagamento = statusPagamento;
        this.comanda_id = comanda_id;
    }

    public PagamentoResponse() {

    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
