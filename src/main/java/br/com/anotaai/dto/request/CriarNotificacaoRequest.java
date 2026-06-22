package br.com.anotaai.dto.request;

import br.com.anotaai.enums.TipoNotificacao;
import jakarta.validation.constraints.NotNull;

public class CriarNotificacaoRequest {

    private String mensagem;

    @NotNull(message = "tipo notificaçao nao pode ser nulo!")
    private TipoNotificacao tipoNotificacao;

    @NotNull(message = "usuario nao pode ser nulo!")
    private Long usuario_id;

    public CriarNotificacaoRequest(String mensagem, TipoNotificacao tipoNotificacao, Long usuario_id) {
        this.mensagem = mensagem;
        this.tipoNotificacao = tipoNotificacao;
        this.usuario_id = usuario_id;
    }

    public CriarNotificacaoRequest() {

    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


    public TipoNotificacao getTipoNotificacao() {
        return tipoNotificacao;
    }

    public void setTipoNotificacao(TipoNotificacao tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }
}
