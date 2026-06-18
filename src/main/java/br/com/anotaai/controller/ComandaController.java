package br.com.anotaai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.anotaai.dto.request.ComandaRequest;
import br.com.anotaai.dto.response.ComandaResponse;
import br.com.anotaai.service.ComandaService;

@RestController
@RequestMapping("/comandas")
public class ComandaController {

    private final ComandaService comandaService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @PostMapping
    public ResponseEntity<ComandaResponse> abrirComanda(@RequestBody ComandaRequest request) {

        return ResponseEntity.ok(comandaService.abrirComanda(request));
    }
}