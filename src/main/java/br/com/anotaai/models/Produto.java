package br.com.anotaai.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.net.URI;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private boolean disponivel;

    private URI imagemURL;


}
