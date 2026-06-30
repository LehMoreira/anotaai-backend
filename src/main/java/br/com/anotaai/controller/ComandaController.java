package br.com.anotaai.controller;

import br.com.anotaai.entity.Comanda;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.anotaai.dto.request.ComandaRequest;
import br.com.anotaai.dto.response.ComandaResponse;
import br.com.anotaai.service.ComandaService;

import java.util.List;

@RestController
@RequestMapping("/comandas")
@CrossOrigin(origins = "http://localhost:5173")

public class ComandaController {

    private final ComandaService comandaService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @PostMapping
    public ResponseEntity<ComandaResponse> abrirComanda(@Valid @RequestBody ComandaRequest request) {

        return ResponseEntity.ok(comandaService.abrirComanda(request));
    }

    @GetMapping
    public ResponseEntity<List<ComandaResponse>> listarComandas() {
        return ResponseEntity.ok(comandaService.listarcomandas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComandaResponse> buscarPorId(@PathVariable Long id) {
        Comanda comanda = comandaService.buscarComandaPorId(id);

        return ResponseEntity.ok(new ComandaResponse(
                comanda.getId(),
                comanda.getDataAbertura(),
                comanda.getValorTotal(),
                comanda.getStatus(),
                comanda.getMesa().getNumeroMesa(),
                comanda.getDataFechamento()
        ));
    }

    @PatchMapping("/{id}/fechar")
    public ResponseEntity<ComandaResponse> fecharComanda(@PathVariable Long id) {
        return ResponseEntity.ok(comandaService.fecharComanda(id));
    }
}