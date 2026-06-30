package br.com.anotaai.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.anotaai.dto.request.ItemPedidoRequest;
import br.com.anotaai.dto.response.ItemPedidoResponse;
import br.com.anotaai.service.ItemPedidoService;

@RestController
@RequestMapping("/pedidos/item")
@CrossOrigin(origins = "http://localhost:5173")

public class ItemPedidoController {
	private final ItemPedidoService itemPedidoService;

	public ItemPedidoController(ItemPedidoService itemPedidoService) {
		this.itemPedidoService = itemPedidoService;
	}
	
	@GetMapping
    public List<ItemPedidoResponse> listarItens() {
        return itemPedidoService.listarItemPedido();
    }


    @PostMapping
    public ResponseEntity<ItemPedidoResponse> save(@RequestBody ItemPedidoRequest item) {
    	ItemPedidoResponse itemResponse = itemPedidoService.criarItemPedido(item);

        return ResponseEntity.status(HttpStatus.CREATED).body(itemResponse);
    }
	
	

	

}
