package br.com.anotaai.dto.response;

import br.com.anotaai.enums.StatusMesa;

public record MesaResponse (

     Long id,

     Long numeroMesa,

     int capacidade,

     StatusMesa statusMesa,
    
     String sessao) {}