package br.com.anotaai.controller;


import br.com.anotaai.dto.request.CriarPagamentoRequest;
import br.com.anotaai.dto.response.PagamentoResponse;
import br.com.anotaai.entity.Pagamento;
import br.com.anotaai.service.PagamentoService;
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
    public void criarPagamento(@RequestBody CriarPagamentoRequest criarPagamentoRequest){
        pagamentoService.criarPagamento(criarPagamentoRequest);
    }

    @GetMapping
    public List<PagamentoResponse> listarPagamento(){
        return pagamentoService.listarpagamento();
    }
}
