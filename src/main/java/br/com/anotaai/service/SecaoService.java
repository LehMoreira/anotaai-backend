package br.com.anotaai.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.anotaai.dto.response.SecaoResponse;
import br.com.anotaai.entity.Secao;
import br.com.anotaai.repository.SecaoRepository;
@Service
public class SecaoService {
	
	private final SecaoRepository secaoRepository;
	

    public SecaoService(SecaoRepository secaoRepository) {
    	this.secaoRepository = secaoRepository;
    }
    public Secao cadastrarSecao(Secao sessao) {
        return secaoRepository.save(sessao);
    }
	public List<SecaoResponse> listarSecao() {
	    return secaoRepository.findAll()
	    		.stream()
                .map(sessao ->  new SecaoResponse(
                		sessao.getId(),
                		sessao.getNome(),
                		sessao.getMesas()))
                    .toList();
	}
	
	public Secao buscarSecaoPorId(Long id) {
	    return secaoRepository.findById(id).orElseThrow(
	            () -> new RuntimeException("id nao encontrado!")
	    );
	}
	
	public void deletarSecao(Long id) {
		secaoRepository.deleteById(id);
	}
	
}
