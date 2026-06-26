package br.com.anotaai.dto.request;

import jakarta.validation.constraints.NotNull;


public record CriarMesaRequest (

    @NotNull(message = "O numero de mesa é obrigatorio!")
    Long numeroMesa,

    @NotNull(message = "A capacidade é obrigatoria!")
    int capacidade,

    @NotNull(message = "a sessao tem que existir!!")
    Long secao_id) {}
