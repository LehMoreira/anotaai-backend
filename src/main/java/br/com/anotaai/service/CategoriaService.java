package br.com.anotaai.service;

import br.com.anotaai.dto.request.CriarCategoriaRequest;
import br.com.anotaai.dto.response.CategoriaResponse;
import br.com.anotaai.entity.Categoria;
import br.com.anotaai.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaResponse criarCategoria(CriarCategoriaRequest categoriaRequest) {
        Categoria categoria = new Categoria();

        categoria.setNome(categoriaRequest.getNome());

        Categoria categoriaNova = categoriaRepository.save(categoria);

        CategoriaResponse categoriaResponse = new CategoriaResponse();

        categoriaResponse.setId(categoriaNova.getId());
        categoriaResponse.setNome(categoriaNova.getNome());

        return categoriaResponse;


    }

    public List<CategoriaResponse> listarCategoria() {
        return categoriaRepository.findAll().stream().map(
                        categoria -> new CategoriaResponse(
                                categoria.getId(),
                                categoria.getNome()))
                .toList();

    }

    public Categoria listarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id nao encontrado!")
        );
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    public void atualizarCategoria(Long id, CategoriaResponse categoriaResponse) {
        Categoria categoria = listarCategoriaPorId(id);

        if (categoria.getNome() != categoriaResponse.getNome()) {
            categoria.setNome(categoriaResponse.getNome());
        }

        categoriaRepository.save(categoria);




    }
}
