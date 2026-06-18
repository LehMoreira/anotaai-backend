package br.com.anotaai.entity;


import br.com.anotaai.enums.StatusMesa;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mesas")

public class Mesa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numeroMesa;

    private int capacidade;

    @Enumerated(EnumType.STRING)
    private StatusMesa statusMesa;

    @OneToMany(mappedBy = "mesa" , fetch = FetchType.LAZY)
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(mappedBy = "mesa" , fetch = FetchType.LAZY )
    private List<Comanda> comandas = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;

	public Mesa() {}

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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}
	
	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
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
		Mesa other = (Mesa) obj;
		return Objects.equals(id, other.id);
	}

    

}
