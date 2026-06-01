package br.com.anotaai.models;


import br.com.anotaai.enums.StatusMesa;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


}
