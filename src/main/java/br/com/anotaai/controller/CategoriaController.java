package br.com.anotaai.controller;

import br.com.anotaai.dto.request.CriarCategoriaRequest;
import br.com.anotaai.dto.response.CategoriaResponse;
import br.com.anotaai.entity.Categoria;
import br.com.anotaai.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:5173")

public class CategoriaController {

    public final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> criarCategoria(@Valid @RequestBody CriarCategoriaRequest categoriaRequest) {
        CategoriaResponse categoriaResponse = categoriaService.criarCategoria(categoriaRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaResponse);
    }

    @GetMapping
    public List<CategoriaResponse> listarCategorias() {
        return categoriaService.listarCategoria();
    }


    @GetMapping("/{id}")
    public Categoria listarCategoriaPorId(@PathVariable Long id) {
        return categoriaService.listarCategoriaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void apagarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
    }

    @PatchMapping("/{id}")
    public void atualizarCategoria(@PathVariable Long id, @Valid @RequestBody CategoriaResponse categoriaResponse) {
        categoriaService.atualizarCategoria(id, categoriaResponse);
    }
}
