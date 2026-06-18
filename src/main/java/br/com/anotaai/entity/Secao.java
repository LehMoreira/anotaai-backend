package br.com.anotaai.entity;

import java.util.ArrayList;
import java.util.List;

import br.com.anotaai.enums.StatusMesa;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "secao")
public class Secao {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "secao" , fetch = FetchType.LAZY)
    private List<Mesa> mesas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}
    
    


}
