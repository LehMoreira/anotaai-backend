package br.com.anotaai.entity;

import br.com.anotaai.enums.FormaPagamento;
import br.com.anotaai.enums.StatusPagamento;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pagamentos")

public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;


    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;


    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comanda_id")
    private Comanda comanda;

    
	public Pagamento() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Comanda getComanda() {
		return comanda;
	}


	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}
    


}
