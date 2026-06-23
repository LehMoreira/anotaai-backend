package br.com.anotaai.controller;


import br.com.anotaai.dto.request.CriarPagamentoRequest;
import br.com.anotaai.dto.response.PagamentoResponse;
import br.com.anotaai.service.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity<PagamentoResponse> criarPagamento(@Valid @RequestBody CriarPagamentoRequest criarPagamentoRequest){
        PagamentoResponse pagamentoResponse =  pagamentoService.criarPagamento(criarPagamentoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoResponse);
    }

    @GetMapping
    public List<PagamentoResponse> listarPagamento(){
        return pagamentoService.listarpagamento();
    }
}
