package br.com.anotaai.controller;

import br.com.anotaai.dto.request.CriarNotificacaoRequest;
import br.com.anotaai.dto.response.CategoriaResponse;
import br.com.anotaai.dto.response.NotificacaoResponse;
import br.com.anotaai.service.NotificacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
@CrossOrigin(origins = "http://localhost:5173")

public class NotificacaoController {


    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @PostMapping
    public ResponseEntity<NotificacaoResponse> criarNotificacao(@Valid @RequestBody CriarNotificacaoRequest criarNotificacaoRequest) {
        NotificacaoResponse notificacaoResponse = notificacaoService.CriarNotificacao(criarNotificacaoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(notificacaoResponse);
    }

    @GetMapping
    public List<NotificacaoResponse> listarNotificacao() {
        return notificacaoService.listarNotificacao();
    }

    @GetMapping("/{login}")
    public List<NotificacaoResponse> buscarNotificacaoPorUsuario(@PathVariable String login) {
        return notificacaoService.buscarNotificacaoPorUsuario(login);
    }

    @PatchMapping("/{id}")
    public void marcarNotificacaoComoLida(@PathVariable Long id){
        notificacaoService.marcarNotificacaoComoLida(id);
    }
}
