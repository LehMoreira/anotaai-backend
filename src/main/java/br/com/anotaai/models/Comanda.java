package br.com.anotaai.models;

import br.com.anotaai.enums.StatusComanda;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "comandas")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor

public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataAbertura;

    private LocalDate  dataFechamento;

    @Column(precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusComanda status;
}
