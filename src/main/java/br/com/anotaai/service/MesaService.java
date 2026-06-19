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



    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;

    }

    public MesaResponse criarMesa(CriarMesaRequest criarMesaRequest) {


        Mesa mesa = new Mesa();


        mesa.setNumeroMesa(criarMesaRequest.getNumeroMesa());


        mesa.setCapacidade(criarMesaRequest.getCapacidade());


        mesa.setStatusMesa(criarMesaRequest.getStatusMesa());

        mesa.setSecao(criarMesaRequest.getSecao());


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


        if (mesa.getStatusMesa() != statusMesa.getStatusMesa()) {
            mesa.setStatusMesa(statusMesa.getStatusMesa());
        }


        mesaRepository.save(mesa);


    }

    public void atualizarMesa(Long id, AtualizarMesaResponse atualizarMesaResponse) {

        Mesa mesa = buscarMesaPorId(id);

        if (mesa.getNumeroMesa() != atualizarMesaResponse.getNumeroMesa()){
            mesa.setNumeroMesa(atualizarMesaResponse.getNumeroMesa());
        }

        if (mesa.getCapacidade() != atualizarMesaResponse.getCapacidade()){
            mesa.setCapacidade(atualizarMesaResponse.getCapacidade());
        }

        mesaRepository.save(mesa);
    }
}
