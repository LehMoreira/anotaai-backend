package br.com.anotaai.service;

import br.com.anotaai.dto.StatusMesaMesaRequest;
import br.com.anotaai.entity.Mesa;
import br.com.anotaai.repository.MesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;
    

    public MesaService(MesaRepository mesaRepository) {
		this.mesaRepository = mesaRepository;
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

    public void atualizarStatusMesa(Long id, StatusMesaMesaRequest statusMesa) {
        Mesa mesa = buscarMesaPorId(id);

        if (statusMesa.getStatusMesa() != mesa.getStatusMesa()) {
            mesa.setStatusMesa(statusMesa.getStatusMesa());

        }


        mesaRepository.save(mesa);
    }
}
