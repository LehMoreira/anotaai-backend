package br.com.anotaai.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.anotaai.dto.request.ComandaRequest;
import br.com.anotaai.dto.response.ComandaResponse;
import br.com.anotaai.entity.Comanda;
import br.com.anotaai.entity.Mesa;
import br.com.anotaai.enums.StatusComanda;
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
    	System.out.println("Mesa recebida: " + comandaRequest.mesaId());

    	Mesa mesa = mesaRepository
    	        .findByNumeroMesa(comandaRequest.mesaId().intValue())
    	        .orElseThrow(() ->
    	                new RuntimeException("Mesa não encontrada"));

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
    
    public ComandaResponse fecharComanda(Long id) {
    	
    	Comanda comanda = buscarComandaPorId(id);
    	
    	if (comanda.getStatus() == StatusComanda.FECHADA) {
            throw new RuntimeException("Comanda já está fechada");
        }
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
