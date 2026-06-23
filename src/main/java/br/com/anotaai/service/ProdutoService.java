package br.com.anotaai.service;

import java.util.List;

import br.com.anotaai.dto.request.CriarProdutoRequest;
import br.com.anotaai.entity.Categoria;
import br.com.anotaai.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import br.com.anotaai.dto.response.ProdutoResponse;
import br.com.anotaai.entity.Produto;
import br.com.anotaai.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;


    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<ProdutoResponse> listarProdutos() {
        return produtoRepository.findAll()
                .stream()
                .map(produto -> new ProdutoResponse(
                        produto.getId(),
                        produto.getNome(),
                        produto.getDescricao(),
                        produto.getPreco(),
                        produto.getDisponivel(),
                        produto.getImagemURL(),
                        produto.getCategoria().getNome()))
                .toList();
    }

    public List<ProdutoResponse> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).stream().map(
                produto -> new ProdutoResponse(
                        produto.getId(),
                        produto.getNome(),
                        produto.getDescricao(),
                        produto.getPreco(),
                        produto.getDisponivel(),
                        produto.getImagemURL(),
                        produto.getCategoria().getNome())).toList();
    }

    public ProdutoResponse criarProduto(CriarProdutoRequest criarProdutoRequest) {

        Produto produto = new Produto();

        produto.setNome(criarProdutoRequest.getNome());
        produto.setDescricao(criarProdutoRequest.getDescricao());
        produto.setPreco(criarProdutoRequest.getPreco());
        produto.setDisponivel(true);
        produto.setImagemURL(criarProdutoRequest.getImagemURL());

        Categoria categoria = categoriaRepository.findById(criarProdutoRequest.getCategoria_id()).orElseThrow(
                () -> new RuntimeException("id nao existe!")
        );

        produto.setCategoria(categoria);

        Produto produtoAtualizado = produtoRepository.save(produto);

        ProdutoResponse produtoResponse = new ProdutoResponse(
                produtoAtualizado.getId(),
                produtoAtualizado.getNome(),
                produtoAtualizado.getDescricao(),
                produtoAtualizado.getPreco(),
                produtoAtualizado.getDisponivel(),
                produtoAtualizado.getImagemURL(),
                produtoAtualizado.getCategoria().getNome()
        );

        return produtoResponse;


    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }


}
