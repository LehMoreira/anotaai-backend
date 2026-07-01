package br.com.anotaai.controller;

import java.util.List;

import br.com.anotaai.dto.request.CriarProdutoRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.anotaai.dto.response.ProdutoResponse;
import br.com.anotaai.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:5173")
public class ProdutoController {
	private final ProdutoService produtoService;
    

    public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
    @PreAuthorize("hasAnyRole('CLIENT','ADMIN','WAITER')")
	@GetMapping
    public List<ProdutoResponse> listarProdutos() {
        return produtoService.listarProdutos();
    }
	@PreAuthorize("hasAnyRole('ADMIN', 'GARCOM','')")
    @GetMapping("/{id}")
    public List<ProdutoResponse> buscarProdutoPorId(@PathVariable Long id){
        return produtoService.buscarProdutoPorId(id);
    }

	@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
    	produtoService.deletarProduto(id);
    }
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(@Valid @RequestBody CriarProdutoRequest criarProdutoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.criarProduto(criarProdutoRequest));
    }

}
