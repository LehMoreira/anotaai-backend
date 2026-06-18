package br.com.anotaai.dto.request;


import br.com.anotaai.entity.Secao;
import br.com.anotaai.enums.StatusMesa;
import jakarta.validation.constraints.NotNull;




public class CriarMesaRequest {

    @NotNull(message = "O numero de mesa é obrigatorio!")
    private Long numeroMesa;

    @NotNull(message = "A capacidade é obrigatoria!")
    private int capacidade;

    @NotNull(message = "O status da mesa é obrigatorio!")
    private StatusMesa statusMesa;

    @NotNull(message = "A área da mesa é obrigatoria!")
    private Secao sessao;
    

    public CriarMesaRequest(Long numeroMesa, int capacidade, StatusMesa statusMesa, Secao sessao) {
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
        this.statusMesa = statusMesa;
        this.sessao=sessao;
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

	public Secao getSessao() {
		return sessao;
	}

	public void setSessao(Secao sessao) {
		this.sessao = sessao;
	}
    
}
