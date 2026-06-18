package br.com.anotaai.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.anotaai.dto.response.SessaoResponse;
import br.com.anotaai.entity.Sessao;
import br.com.anotaai.repository.SessaoRepository;
@Service
public class SessaoService {
	
	private final SessaoRepository sessaoRepository;
	

    public SessaoService(SessaoRepository sessaoRepository) {
    	this.sessaoRepository = sessaoRepository;
    }
    public Sessao cadastrarProduto(Sessao sessao) {
        return sessaoRepository.save(sessao);
    }
	public List<SessaoResponse> listarSessao() {
	    return sessaoRepository.findAll()
	    		.stream()
                .map(sessao ->  new SessaoResponse(
                		sessao.getId(),
                		sessao.getNome(),
                		sessao.getMesas()))
                    .toList();
	}
	
	public Sessao buscarSessaoPorId(Long id) {
	    return sessaoRepository.findById(id).orElseThrow(
	            () -> new RuntimeException("id nao encontrado!")
	    );
	}
	
	public void deletarSessao(Long id) {
		sessaoRepository.deleteById(id);
	}
	
}
