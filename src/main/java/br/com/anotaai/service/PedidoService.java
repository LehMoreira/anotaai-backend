package br.com.anotaai.service;


import br.com.anotaai.dto.request.ItemPedidoRequest;
import br.com.anotaai.dto.request.PedidoRequest;
import br.com.anotaai.dto.request.StatusPedidoRequest;
import br.com.anotaai.dto.response.ItemPedidoResponse;
import br.com.anotaai.dto.response.PedidoResponse;
import br.com.anotaai.entity.Comanda;
import br.com.anotaai.entity.ItemPedido;
import br.com.anotaai.entity.Pedido;
import br.com.anotaai.entity.Produto;
import br.com.anotaai.entity.Usuario;
import br.com.anotaai.enums.StatusItemPedido;
import br.com.anotaai.enums.StatusPedido;
import br.com.anotaai.repository.ComandaRepository;
import br.com.anotaai.repository.PedidoRepository;
import br.com.anotaai.repository.ProdutoRepository;
import br.com.anotaai.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ComandaRepository comandaRepository;

	public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository,
			UsuarioRepository usuarioRepository, ComandaRepository comandaRepository) {
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
		this.usuarioRepository = usuarioRepository;
		this.comandaRepository = comandaRepository;
	}


	public List<PedidoResponse> listarPedidos() {
        return pedidoRepository.findAll()
        		.stream()
                .map(pedido -> new PedidoResponse(
                        pedido.getId(),
                        pedido.getDataHora(),
                        pedido.getObservacao(),
                        pedido.getStatusPedido(),
                        pedido.getMesa().getNumeroMesa(),
                        pedido.getUsuario().getNome(),
                        pedido.getItemPedidoList()
                        .stream()
                        .map(item -> new ItemPedidoResponse(
                                item.getId(),
                                item.getQuantidade(),
                                item.getPrecoUnitario(),
                                item.getStatusEntrega(),
                                item.getProduto().getNome(),
                                pedido.getId()))
                        .toList()))
                .toList();
    }


    public Pedido listarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado!")
        );
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    public void atualizarStatusPedido(Long id, StatusPedidoRequest statusPedidoRequest) {
        Pedido pedido = listarPedidoPorId(id);

        if (pedido.getStatusPedido() != statusPedidoRequest.getStatusPedido()) {
            pedido.setStatusPedido(statusPedidoRequest.getStatusPedido());
        }

        pedidoRepository.save(pedido);
    }


    
    public PedidoResponse criarPedido(PedidoRequest pedidoRequest) {

    	Comanda comanda = comandaRepository.findById(pedidoRequest.comandaId())
    	        .orElseThrow(() -> new RuntimeException("Comanda não encontrada"));

        Usuario usuario = usuarioRepository.findById(pedidoRequest.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Pedido pedido = new Pedido();

        pedido.setDataHora(LocalDateTime.now());
        pedido.setObservacao(pedidoRequest.observacao());
        pedido.setComanda(comanda);
        pedido.setMesa(comanda.getMesa());
        pedido.setUsuario(usuario);
        pedido.setStatusPedido(StatusPedido.NOVO_PEDIDO);

        List<ItemPedido> itens = new ArrayList<>();

        for (ItemPedidoRequest itemRequest : pedidoRequest.itens()) {

            Produto produto = produtoRepository.findById(itemRequest.idProduto())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            ItemPedido item = new ItemPedido();

            item.setPedido(pedido);
            item.setProduto(produto);
            item.setQuantidade(itemRequest.quantidade());
            item.setPrecoUnitario(produto.getPreco());
            item.setStatusEntrega(StatusItemPedido.AGUARDANDO);

            itens.add(item);
        }

        pedido.setItemPedidoList(itens);
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        comanda.getPedidos().add(pedido);
        
        BigDecimal totalPedido = itens.stream()
                .map(item -> item.getPrecoUnitario()
                        .multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        comanda.setValorTotal(comanda.getValorTotal().add(totalPedido));

        return new PedidoResponse(
        		pedidoSalvo.getId(),
        		pedidoSalvo.getDataHora(),
        		pedidoSalvo.getObservacao(),
        		pedidoSalvo.getStatusPedido(),
        		pedidoSalvo.getMesa().getNumeroMesa(),
        		pedidoSalvo.getUsuario().getNome(),
        		pedidoSalvo.getItemPedidoList()
                .stream()
                .map(item -> new ItemPedidoResponse(
                        item.getId(),
                        item.getQuantidade(),
                        item.getPrecoUnitario(),
                        item.getStatusEntrega(),
                        item.getProduto().getNome(),
                        pedidoSalvo.getId()))
                .toList());
    }
}
