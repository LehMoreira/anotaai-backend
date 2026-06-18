package br.com.anotaai.service;


import br.com.anotaai.dto.request.StatusPedidoRequest;


import br.com.anotaai.entity.Pedido;

import br.com.anotaai.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    

    public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}


	public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }


    public Pedido listarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado!")
        );
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    public void atualizarStatusPedido(Long id, StatusPedidoRequest statusPedido) {
        Pedido pedido = listarPedidoPorId(id);

        if (pedido.getStatusPedido() != statusPedido.getStatusPedido()) {
            pedido.setStatusPedido(statusPedido.getStatusPedido());
        }

        pedidoRepository.save(pedido);
    }
}
