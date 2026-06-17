package br.com.anotaai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.anotaai.dto.ProdutoResponse;
import br.com.anotaai.entity.Produto;
import br.com.anotaai.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
private final ProdutoRepository produtoRepository;
    

    public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
    
    public List<ProdutoResponse> listarProdutos() {
        return produtoRepository.findAll()
        		.stream()
                .map(produto ->  new ProdutoResponse(
                	produto.getId(),
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco(),
                    produto.isDisponivel(),
                    produto.getImagemURL()))
                .toList();
    }
    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id nao encontrado!"));
    }
    public Produto cadastrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
    public void deletarProduto(Long id) {
    	produtoRepository.deleteById(id);
    }
    
    

}
