package br.com.anotaai.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.anotaai.dto.response.SessaoResponse;
import br.com.anotaai.entity.Sessao;
import br.com.anotaai.service.SessaoService;

@RestController
@RequestMapping("/sessao")
public class SessaoController {
	private final SessaoService sessaoService;
	
	public SessaoController(SessaoService sessaoService) {
		this.sessaoService = sessaoService;
	}

	@GetMapping
    public List<SessaoResponse> listarSessao() {
        return sessaoService.listarSessao();
    }

    @GetMapping("/{id}")
    public Sessao buscarProdutoPorId(@PathVariable Long id){
        return sessaoService.buscarSessaoPorId(id);
    }


    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
    	sessaoService.deletarSessao(id);
    }
    @PostMapping
    public ResponseEntity<Sessao> save(@RequestBody Sessao sessao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sessaoService.cadastrarProduto(sessao));
    }

}
