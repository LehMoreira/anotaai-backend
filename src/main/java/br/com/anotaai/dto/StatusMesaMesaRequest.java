package br.com.anotaai.dto;

import br.com.anotaai.enums.StatusMesa;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StatusMesaMesaRequest {

    @NotNull(message = "O status e obrigatorio!")
    private StatusMesa statusMesa;
}
