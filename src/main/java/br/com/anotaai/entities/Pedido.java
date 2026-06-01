package br.com.anotaai.entities;


import br.com.anotaai.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private String observacao;

    private Usuario origemPedido;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;
}
