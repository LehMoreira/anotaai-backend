package br.com.anotaai.service;

import java.util.List;

import br.com.anotaai.dto.request.CriarSecaoRequest;
import br.com.anotaai.dto.response.MesaResponse;
import br.com.anotaai.entity.Mesa;
import br.com.anotaai.repository.MesaRepository;
import org.springframework.stereotype.Service;
import br.com.anotaai.dto.response.SecaoResponse;
import br.com.anotaai.entity.Secao;
import br.com.anotaai.repository.SecaoRepository;

@Service
public class SecaoService {

    private final SecaoRepository secaoRepository;
    private final MesaRepository mesaRepository;


    public SecaoService(SecaoRepository secaoRepository, MesaRepository mesaRepository) {
        this.secaoRepository = secaoRepository;
        this.mesaRepository = mesaRepository;
    }


    public SecaoResponse cadastrarSecao(CriarSecaoRequest criarSecaoRequest) {

        Secao secao = new Secao();

        secao.setNome(criarSecaoRequest.getNome());

        Secao secaoAtualizada = secaoRepository.save(secao);

        SecaoResponse secaoResponse = new SecaoResponse(
                secaoAtualizada.getId(),
                secaoAtualizada.getNome(),
                secaoAtualizada.getMesas().stream().map(
                        mesa -> new MesaResponse(
                                mesa.getId(),
                                mesa.getNumeroMesa(),
                                mesa.getCapacidade(),
                                mesa.getStatusMesa(),
                                mesa.getSecao().getNome())).toList()
        );

        return secaoResponse;


    }


    public List<SecaoResponse> listarSecao() {
        return secaoRepository.findAll()
                .stream()
                .map(sessao -> new SecaoResponse(
                        sessao.getId(),
                        sessao.getNome(),
                        sessao.getMesas().stream().map(
                                mesa -> new MesaResponse(
                                        mesa.getId(),
                                        mesa.getNumeroMesa(),
                                        mesa.getCapacidade(),
                                        mesa.getStatusMesa(),
                                        mesa.getSecao().getNome()
                                )
                        ).toList()))
                .toList();
    }

    public List<SecaoResponse> buscarSecaoPorId(Long id) {
        return secaoRepository.findById(id)
                .stream()
                .map(sessao -> new SecaoResponse(
                        sessao.getId(),
                        sessao.getNome(),
                        sessao.getMesas().stream().map(mesa -> new MesaResponse(
                                mesa.getId(),
                                mesa.getNumeroMesa(),
                                mesa.getCapacidade(),
                                mesa.getStatusMesa(),
                                mesa.getSecao().getNome()
                        )).toList()))
                .toList();
    }

    public void deletarSecao(Long id) {
        secaoRepository.deleteById(id);
    }


}
