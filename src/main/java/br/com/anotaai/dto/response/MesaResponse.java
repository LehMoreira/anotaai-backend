package br.com.anotaai.dto.response;

import br.com.anotaai.entity.Secao;
import br.com.anotaai.enums.StatusMesa;

public record MesaResponse (

     Long numeroMesa,

     int capacidade,

     StatusMesa statusMesa,
    
     String secao) {}