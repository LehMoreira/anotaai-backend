package br.com.anotaai.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.anotaai.dto.response.SecaoResponse;
import br.com.anotaai.entity.Secao;
import br.com.anotaai.service.SecaoService;

@RestController
@RequestMapping("/secao")
public class SecaoController {
	private final SecaoService secaoService;
	
	public SecaoController(SecaoService secaoService) {
		this.secaoService = secaoService;
	}

	@GetMapping
    public List<SecaoResponse> listarSessao() {
        return secaoService.listarSecao();
    }

    @GetMapping("/{id}")
    public Secao buscarSesaoPorId(@PathVariable Long id){
        return secaoService.buscarSecaoPorId(id);
    }


    @DeleteMapping("/{id}")
    public void deletarSesao(@PathVariable Long id){
    	secaoService.deletarSecao(id);
    }
    @PostMapping
    public ResponseEntity<Secao> save(@RequestBody Secao secao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(secaoService.cadastrarSecao(secao));
    }

}
