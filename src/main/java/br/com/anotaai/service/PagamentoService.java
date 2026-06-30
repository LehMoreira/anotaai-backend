package br.com.anotaai.service;

import br.com.anotaai.dto.request.CriarPagamentoRequest;
import br.com.anotaai.dto.response.PagamentoResponse;
import br.com.anotaai.entity.Comanda;
import br.com.anotaai.entity.Mesa;
import br.com.anotaai.entity.Pagamento;
import br.com.anotaai.enums.StatusMesa;
import br.com.anotaai.enums.StatusPagamento;
import br.com.anotaai.repository.ComandaRepository;
import br.com.anotaai.repository.MesaRepository;
import br.com.anotaai.repository.PagamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final ComandaRepository comandaRepository;
    private final MesaRepository mesaRepository;
    private final ComandaService comandaService;

    public PagamentoService(
            PagamentoRepository pagamentoRepository,
            ComandaRepository comandaRepository,
            MesaRepository mesaRepository,
            ComandaService comandaService
    ) {
        this.pagamentoRepository = pagamentoRepository;
        this.comandaRepository = comandaRepository;
        this.mesaRepository = mesaRepository;
        this.comandaService = comandaService;
    }

    public PagamentoResponse criarPagamento(CriarPagamentoRequest criarPagamentoRequest) {
        Comanda comanda = comandaRepository.findById(criarPagamentoRequest.getComanda_id())
                .orElseThrow(() -> new RuntimeException("Comanda não encontrada"));

        comandaService.recalcularValorTotal(comanda);

        Pagamento pagamento = new Pagamento();
        pagamento.setDataHora(java.time.LocalDateTime.now());
        pagamento.setFormaPagamento(criarPagamentoRequest.getFormaPagamento());
        pagamento.setStatusPagamento(criarPagamentoRequest.getStatusPagamento());
        pagamento.setComanda(comanda);
        pagamento.setValor(comanda.getValorTotal());

        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);

        return new PagamentoResponse(
                pagamentoSalvo.getId(),
                pagamentoSalvo.getValor(),
                pagamentoSalvo.getDataHora(),
                pagamentoSalvo.getFormaPagamento(),
                pagamentoSalvo.getStatusPagamento(),
                pagamentoSalvo.getComanda().getId()
        );
    }

    public List<PagamentoResponse> listarpagamento() {
        return pagamentoRepository.findAll()
                .stream()
                .map(pagamento -> new PagamentoResponse(
                        pagamento.getId(),
                        pagamento.getValor(),
                        pagamento.getDataHora(),
                        pagamento.getFormaPagamento(),
                        pagamento.getStatusPagamento(),
                        pagamento.getComanda().getId()
                ))
                .toList();
    }

    @Transactional
    public void concluirPagamento(Long pagamentoId) {
        Pagamento pagamento = pagamentoRepository.findById(pagamentoId)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        pagamento.setStatusPagamento(StatusPagamento.CONFIRMADO);

        Comanda comanda = pagamento.getComanda();
        if (comanda == null) {
            throw new RuntimeException("Pagamento sem comanda vinculada");
        }

        Mesa mesa = comanda.getMesa();
        if (mesa == null) {
            throw new RuntimeException("Comanda sem mesa vinculada");
        }

        mesa.setStatusMesa(StatusMesa.LIVRE);

        pagamentoRepository.save(pagamento);
        mesaRepository.save(mesa);
    }
}