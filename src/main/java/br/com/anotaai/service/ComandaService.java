package br.com.anotaai.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.anotaai.dto.request.ComandaRequest;
import br.com.anotaai.dto.response.ComandaResponse;
import br.com.anotaai.entity.Comanda;
import br.com.anotaai.entity.ItemPedido;
import br.com.anotaai.entity.Mesa;
import br.com.anotaai.entity.Pedido;
import br.com.anotaai.enums.StatusComanda;
import br.com.anotaai.enums.StatusMesa;
import br.com.anotaai.repository.ComandaRepository;
import br.com.anotaai.repository.MesaRepository;

@Service
public class ComandaService {

    private final ComandaRepository comandaRepository;
    private final MesaRepository mesaRepository;

    public ComandaService(
            ComandaRepository comandaRepository,
            MesaRepository mesaRepository) {
        this.comandaRepository = comandaRepository;
        this.mesaRepository = mesaRepository;
    }

    public ComandaResponse abrirComanda(ComandaRequest comandaRequest) {
        Mesa mesa = mesaRepository.findByNumeroMesa(comandaRequest.numeroMesa());

        if (mesa == null) {
            throw new RuntimeException("Mesa não encontrada");
        }

        if (mesa.getStatusMesa() != StatusMesa.LIVRE) {
            throw new RuntimeException("A mesa já está ocupada");
        }

        mesa.setStatusMesa(StatusMesa.OCUPADA);
        mesaRepository.save(mesa);

        Comanda comanda = new Comanda();
        comanda.setMesa(mesa);
        comanda.setDataAbertura(LocalDate.now());
        comanda.setStatus(StatusComanda.ABERTA);
        comanda.setValorTotal(BigDecimal.ZERO);

        Comanda comandaSalva = comandaRepository.save(comanda);

        return new ComandaResponse(
                comandaSalva.getId(),
                comandaSalva.getDataAbertura(),
                comandaSalva.getValorTotal(),
                comandaSalva.getStatus(),
                comandaSalva.getMesa().getNumeroMesa(),
                comandaSalva.getDataFechamento()
        );
    }

    public List<ComandaResponse> listarcomandas() {
        return comandaRepository.findAll()
                .stream()
                .map(comanda -> new ComandaResponse(
                        comanda.getId(),
                        comanda.getDataAbertura(),
                        comanda.getValorTotal(),
                        comanda.getStatus(),
                        comanda.getMesa().getNumeroMesa(),
                        comanda.getDataFechamento()))
                .toList();
    }

    public Comanda buscarComandaPorId(Long id) {
        return comandaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comanda não encontrada"));
    }

    public BigDecimal recalcularValorTotal(Comanda comanda) {
        BigDecimal total = BigDecimal.ZERO;

        if (comanda.getPedidos() != null) {
            for (Pedido pedido : comanda.getPedidos()) {
                if (pedido.getItemPedidoList() != null) {
                    for (ItemPedido item : pedido.getItemPedidoList()) {
                        BigDecimal preco = item.getPrecoUnitario();
                        BigDecimal quantidade = BigDecimal.valueOf(item.getQuantidade());
                        total = total.add(preco.multiply(quantidade));
                    }
                }
            }
        }

        comanda.setValorTotal(total);
        comandaRepository.save(comanda);

        return total;
    }

    public ComandaResponse fecharComanda(Long id) {
        Comanda comanda = buscarComandaPorId(id);

        if (comanda.getStatus() == StatusComanda.FECHADA) {
            throw new RuntimeException("Comanda já está fechada");
        }

        recalcularValorTotal(comanda);

        comanda.setDataFechamento(LocalDate.now());
        comanda.setStatus(StatusComanda.FECHADA);

        Comanda comandaSalva = comandaRepository.save(comanda);

        return new ComandaResponse(
                comandaSalva.getId(),
                comandaSalva.getDataAbertura(),
                comandaSalva.getValorTotal(),
                comandaSalva.getStatus(),
                comandaSalva.getMesa().getNumeroMesa(),
                comandaSalva.getDataFechamento()
        );
    }
}