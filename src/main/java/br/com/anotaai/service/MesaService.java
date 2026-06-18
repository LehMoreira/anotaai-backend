package br.com.anotaai.service;

import br.com.anotaai.dto.request.CriarMesaRequest;
import br.com.anotaai.dto.request.StatusMesaRequest;
import br.com.anotaai.dto.response.MesaResponse;
import br.com.anotaai.entity.Mesa;
import br.com.anotaai.repository.MesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MesaService {

    private final MesaRepository mesaRepository;


        public MesaResponse salvarMesa(CriarMesaRequest criarMesaRequest) {

        Mesa mesa = new Mesa();

        mesa.setNumeroMesa(criarMesaRequest.getNumeroMesa());

        mesa.setCapacidade(criarMesaRequest.getCapacidade());

        mesa.setStatusMesa(criarMesaRequest.getStatusMesa());

        Mesa mesaSalva = mesaRepository.save(mesa);

        MesaResponse mesaResponse = new MesaResponse();

        mesaResponse.setId(mesaSalva.getId());
        mesaResponse.setNumeroMesa(mesaSalva.getNumeroMesa());
        mesaResponse.setCapacidade(mesaSalva.getCapacidade());
        mesaResponse.setStatusMesa(mesaSalva.getStatusMesa());

        return mesaResponse;

    }


    public List<Mesa> listarMesas() {
        return mesaRepository.findAll();
    }

    public Mesa buscarMesaPorId(Long id) {
        return mesaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id nao encontrado!")
        );
    }

    public void deletarMesa(Long id) {
        mesaRepository.deleteById(id);
    }

    public void atualizarStatusMesa(Long id, StatusMesaRequest statusMesa) {
        Mesa mesa = buscarMesaPorId(id);

        if (mesa.getStatusMesa() != statusMesa.getStatusMesa()){
            mesa.setStatusMesa(statusMesa.getStatusMesa());
        }

        mesaRepository.save(mesa);
    }
}
