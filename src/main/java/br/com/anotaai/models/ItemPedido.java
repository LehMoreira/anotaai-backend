package br.com.anotaai.models;


import br.com.anotaai.enums.StatusItemPedido;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "itemsPedido")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor

public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;

    private BigDecimal precoUnitario;

    @Enumerated(EnumType.STRING)
    private StatusItemPedido  statusEntrega;


}
