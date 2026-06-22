package br.com.anotaai.controller;

import br.com.anotaai.dto.request.CriarNotificacaoRequest;
import br.com.anotaai.dto.response.NotificacaoResponse;
import br.com.anotaai.service.NotificacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {


    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @PostMapping
    public NotificacaoResponse criarNotificacao(@Valid @RequestBody CriarNotificacaoRequest criarNotificacaoRequest) {
        return notificacaoService.CriarNotificacao(criarNotificacaoRequest);
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
