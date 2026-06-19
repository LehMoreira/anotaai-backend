package br.com.anotaai.service;


import br.com.anotaai.dto.request.CriarPagamentoRequest;

import br.com.anotaai.dto.response.PagamentoResponse;

import br.com.anotaai.entity.Comanda;
import br.com.anotaai.entity.Pagamento;
import br.com.anotaai.repository.ComandaRepository;
import br.com.anotaai.repository.PagamentoRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final ComandaRepository comandaRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository, ComandaRepository comandaRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.comandaRepository = comandaRepository;
    }

    public PagamentoResponse criarPagamento(CriarPagamentoRequest criarPagamentoRequest) {
        Pagamento pagamento = new Pagamento();

        pagamento.setDataHora(criarPagamentoRequest.getDataHora());
        pagamento.setFormaPagamento(criarPagamentoRequest.getFormaPagamento());
        pagamento.setStatusPagamento(criarPagamentoRequest.getStatusPagamento());

        Comanda comanda = comandaRepository.findById(criarPagamentoRequest.getComanda_id()).orElseThrow(
                () -> new RuntimeException("id nao encontrado!")
        );

        pagamento.setComanda(comanda);

        pagamento.setValor(comanda.getValorTotal());

        Pagamento pagamentoAtualizado = pagamentoRepository.save(pagamento);

        PagamentoResponse pagamentoResponse = new PagamentoResponse();

        pagamentoResponse.setValor(pagamentoAtualizado.getValor());
        pagamentoResponse.setDataHora(pagamentoAtualizado.getDataHora());
        pagamentoResponse.setFormaPagamento(pagamentoAtualizado.getFormaPagamento());
        pagamentoResponse.setStatusPagamento(pagamentoAtualizado.getStatusPagamento());
        pagamentoResponse.setComanda_id(pagamentoAtualizado.getComanda().getId());

        return pagamentoResponse;


    }

    public List<PagamentoResponse> listarpagamento(){
        return pagamentoRepository.findAll()
                .stream()
                .map(pagamento ->  new PagamentoResponse(
                       pagamento.getValor(),
                        pagamento.getDataHora(),
                        pagamento.getFormaPagamento(),
                        pagamento.getStatusPagamento(),
                        pagamento.getComanda().getId()))
                .toList();
    }


}
