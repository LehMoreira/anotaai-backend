package br.com.anotaai.service;


import br.com.anotaai.dto.request.CriarMesaRequest;
import br.com.anotaai.dto.request.StatusMesaRequest;
import br.com.anotaai.dto.response.AtualizarMesaResponse;
import br.com.anotaai.dto.response.MesaResponse;
import br.com.anotaai.entity.Mesa;
import br.com.anotaai.entity.Secao;
import br.com.anotaai.repository.MesaRepository;
import br.com.anotaai.repository.SecaoRepository;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class MesaService {


    private final MesaRepository mesaRepository;
    private final SecaoRepository secaoRepository;



    public MesaService(MesaRepository mesaRepository,SecaoRepository secaoRepository) {
        this.mesaRepository = mesaRepository;
        this.secaoRepository = secaoRepository;

    }

    public MesaResponse criarMesa(CriarMesaRequest criarMesaRequest) {

        Mesa mesa = new Mesa();

        mesa.setNumeroMesa(criarMesaRequest.getNumeroMesa());

        mesa.setCapacidade(criarMesaRequest.getCapacidade());

        mesa.setStatusMesa(criarMesaRequest.getStatusMesa());

        Secao secao = secaoRepository.findById(criarMesaRequest.getSecao_id()).orElseThrow(() -> new RuntimeException("Id nao existe!"));

        mesa.setSecao(secao);

        Mesa mesaSalva = mesaRepository.save(mesa);

        MesaResponse response = new MesaResponse(
                mesaSalva.getId(),
                mesaSalva.getNumeroMesa(),
                mesaSalva.getCapacidade(),
                mesaSalva.getStatusMesa(),
                mesaSalva.getSecao().getNome());

        return response;

    }


    public List<MesaResponse> listarMesas() {
        return mesaRepository.findAll()
                .stream()
                .map(mesa -> new MesaResponse(
                        mesa.getId(),
                        mesa.getNumeroMesa(),
                        mesa.getCapacidade(),
                        mesa.getStatusMesa(),
                        mesa.getSecao().getNome()))
                .toList();
    }


    public List<MesaResponse> buscarMesaPorId(Long id) {
        return mesaRepository.findById(id)
                .stream()
                .map(mesa -> new MesaResponse(
                        mesa.getId(),
                        mesa.getNumeroMesa(),
                        mesa.getCapacidade(),
                        mesa.getStatusMesa(),
                        mesa.getSecao().getNome()))
                .toList();
    }


    public void deletarMesa(Long id) {
        mesaRepository.deleteById(id);
    }


    public void atualizarStatusMesa(Long id, StatusMesaRequest statusMesa) {
        Mesa mesa = mesaRepository.findById(id).orElseThrow(() -> new RuntimeException("Id nao existe!"));


        if (mesa.getStatusMesa() != statusMesa.getStatusMesa()) {
            mesa.setStatusMesa(statusMesa.getStatusMesa());
        }


        mesaRepository.save(mesa);


    }

    public void atualizarMesa(Long id, AtualizarMesaResponse atualizarMesaResponse) {

        Mesa mesa = mesaRepository.findById(id).orElseThrow(() -> new RuntimeException("Id nao existe!"));


        if (mesa.getNumeroMesa() != atualizarMesaResponse.getNumeroMesa()){
            mesa.setNumeroMesa(atualizarMesaResponse.getNumeroMesa());
        }

        if (mesa.getCapacidade() != atualizarMesaResponse.getCapacidade()){
            mesa.setCapacidade(atualizarMesaResponse.getCapacidade());
        }

        mesaRepository.save(mesa);
    }
}
