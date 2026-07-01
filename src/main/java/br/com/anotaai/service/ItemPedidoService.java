package br.com.anotaai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.anotaai.dto.request.ItemPedidoRequest;
import br.com.anotaai.dto.response.ItemPedidoResponse;
import br.com.anotaai.entity.ItemPedido;
import br.com.anotaai.entity.Pedido;
import br.com.anotaai.entity.Produto;
import br.com.anotaai.enums.StatusItemPedido;
import br.com.anotaai.repository.ItemPedidoRepository;
import br.com.anotaai.repository.PedidoRepository;
import br.com.anotaai.repository.ProdutoRepository;

@Service
public class ItemPedidoService {
	private final ItemPedidoRepository itemPedidoRepository;
	private final ProdutoRepository produtoRepository;
	private final PedidoRepository pedidoRepository;
	
	
	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository, ProdutoRepository produtoRepository,
			PedidoRepository pedidoRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
		this.produtoRepository = produtoRepository;
		this.pedidoRepository = pedidoRepository;
	}

	public List<ItemPedidoResponse> listarItemPedido() {
	    return itemPedidoRepository.findAll()
	    		.stream()
                .map(itemPedido ->  new ItemPedidoResponse(
                		itemPedido.getId(),
                		itemPedido.getQuantidade(),
                		itemPedido.getPrecoUnitario(),
                		itemPedido.getStatusEntrega(),
                		itemPedido.getProduto().getNome(),
                		itemPedido.getPedido().getId()))
                    .toList();
	}

    public ItemPedidoResponse criarItemPedido(ItemPedidoRequest itemPedidoRequest) {

        Produto produto = produtoRepository.findById(itemPedidoRequest.idProduto())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Pedido pedido = pedidoRepository.findById(itemPedidoRequest.idPedido())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        ItemPedido item = new ItemPedido();

        item.setQuantidade(itemPedidoRequest.quantidade());
        item.setPrecoUnitario(produto.getPreco());
        item.setStatusEntrega(StatusItemPedido.AGUARDANDO);
        item.setProduto(produto);
        item.setPedido(pedido);

        ItemPedido itemSalvo = itemPedidoRepository.save(item);

        return new ItemPedidoResponse(
                itemSalvo.getId(),
                itemSalvo.getQuantidade(),
                itemSalvo.getPrecoUnitario(),
                itemSalvo.getStatusEntrega(),
                itemSalvo.getProduto().getNome(),
                itemSalvo.getPedido().getId());
    }

    public void deleterItemPedido(Long id){
        itemPedidoRepository.deleteById(id);
    }

}
