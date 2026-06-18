package br.com.anotaai.dto.response;

import java.util.List;

import br.com.anotaai.entity.Mesa;


public record SecaoResponse(Long id, String nome, List<Mesa> mesas ) {


}
