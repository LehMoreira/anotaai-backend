package br.com.anotaai.entity;


import br.com.anotaai.enums.TipoNotificacao;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notificacoes")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    private LocalDateTime dataHora;

    private boolean lida;

    @Enumerated(EnumType.STRING)
    private TipoNotificacao tipo;
}
