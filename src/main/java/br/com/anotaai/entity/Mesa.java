package br.com.anotaai.entity;


import br.com.anotaai.enums.StatusMesa;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mesas")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor

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



}
