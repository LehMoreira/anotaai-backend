package br.com.anotaai.dto.response;

import br.com.anotaai.entity.Usuario;
import br.com.anotaai.enums.TipoNotificacao;

import java.time.LocalDateTime;

public class NotificacaoResponse {

    private Long id;

    private String mensagem;

    private LocalDateTime dataHora;

    private boolean lida;

    private TipoNotificacao tipoNotificacao;

    private String login;

    public NotificacaoResponse(Long id, String mensagem, LocalDateTime dataHora, boolean lida, TipoNotificacao tipoNotificacao, String login) {
        this.id = id;
        this.mensagem = mensagem;
        this.dataHora = dataHora;
        this.lida = lida;
        this.tipoNotificacao = tipoNotificacao;
        this.login = login;
    }

    public NotificacaoResponse() {

    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }

    public TipoNotificacao getTipoNotificacao() {
        return tipoNotificacao;
    }

    public void setTipoNotificacao(TipoNotificacao tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
