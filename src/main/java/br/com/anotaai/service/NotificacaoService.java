package br.com.anotaai.service;

import br.com.anotaai.dto.request.CriarNotificacaoRequest;

import br.com.anotaai.dto.response.NotificacaoResponse;
import br.com.anotaai.entity.Notificacao;
import br.com.anotaai.entity.Usuario;
import br.com.anotaai.repository.NotificacaoRepository;
import br.com.anotaai.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;
    private final UsuarioRepository usuarioRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository, UsuarioRepository usuarioRepository) {
        this.notificacaoRepository = notificacaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public NotificacaoResponse CriarNotificacao(CriarNotificacaoRequest criarNotificacaoRequest) {

        Notificacao notificacao = new Notificacao();

        notificacao.setMensagem(criarNotificacaoRequest.getMensagem());
        notificacao.setTipoNotificacao(criarNotificacaoRequest.getTipoNotificacao());
        notificacao.setDataHora(LocalDateTime.now());

        Usuario usuario = usuarioRepository.findById(criarNotificacaoRequest.getUsuario_id()).orElseThrow(
                () -> new RuntimeException("id nao existe!")
        );

        notificacao.setUsuario(usuario);

        Notificacao notificacaoAtualizada = notificacaoRepository.save(notificacao);

        NotificacaoResponse notificacaoResponse = new NotificacaoResponse();

        notificacaoResponse.setMensagem(notificacaoAtualizada.getMensagem());
        notificacaoResponse.setDataHora(notificacaoAtualizada.getDataHora());
        notificacaoResponse.setLida(notificacaoAtualizada.isLida());
        notificacaoResponse.setTipoNotificacao(notificacaoAtualizada.getTipoNotificacao());
        notificacaoResponse.setLogin(notificacaoAtualizada.getUsuario().getNome());

        return notificacaoResponse;


    }

    public List<NotificacaoResponse> listarNotificacao() {
        return notificacaoRepository.findAll()
                .stream()
                .map(
                        notificacao -> new NotificacaoResponse(
                                notificacao.getMensagem(),
                                notificacao.getDataHora(),
                                notificacao.isLida(),
                                notificacao.getTipoNotificacao(),
                                notificacao.getUsuario().getNome()
                        )).toList();
    }


    public List<NotificacaoResponse> buscarNotificacaoPorUsuario(String nome) {

        return notificacaoRepository.findByUsuario_Nome(nome).stream().map(
                notificacao -> new NotificacaoResponse(
                        notificacao.getMensagem(),
                        notificacao.getDataHora(),
                        notificacao.isLida(),
                        notificacao.getTipoNotificacao(),
                        notificacao.getUsuario().getNome()
                )).toList();

    }

    public void marcarNotificacaoComoLida(Long id) {
        Notificacao notificacao = notificacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Id nao existe!"));

        notificacao.setLida(true);

        notificacaoRepository.save(notificacao);
    }
}


