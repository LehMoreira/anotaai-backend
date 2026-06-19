package br.com.anotaai.controller;



import br.com.anotaai.dto.request.PedidoRequest;
import br.com.anotaai.dto.request.StatusPedidoRequest;
import br.com.anotaai.dto.response.PedidoResponse;
import br.com.anotaai.entity.Pedido;
import br.com.anotaai.service.PedidoService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")

public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoService.listarPedidos();
    }

    @GetMapping("/{id}")
    public Pedido listarPedidos(@PathVariable Long id){
        return pedidoService.listarPedidoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id){
        pedidoService.deletarPedido(id);
    }

    @PatchMapping("/{id}/status")
    public void atualizarStatusPedido(@PathVariable Long id, @Valid @RequestBody StatusPedidoRequest statusPedidoRequest){
        pedidoService.atualizarStatusPedido(id, statusPedidoRequest);
    }
    @PostMapping
    public ResponseEntity<PedidoResponse> criarPedido(@RequestBody PedidoRequest request) {

        return ResponseEntity.ok(pedidoService.criarPedido(request));
    }
}
