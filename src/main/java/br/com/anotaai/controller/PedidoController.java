package br.com.anotaai.controller;


import br.com.anotaai.dto.request.CriarPedidoRequest;
import br.com.anotaai.dto.request.StatusPedidoRequest;
import br.com.anotaai.dto.response.PedidoResponse;
import br.com.anotaai.entity.Pedido;
import br.com.anotaai.enums.StatusPedido;
import br.com.anotaai.service.PedidoService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:5173")

public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<PedidoResponse> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    //@PreAuthorize("hasAnyRole('ADMIN', 'WAITER')")
    @GetMapping("/{id}")
    public Pedido listarPedidosPorId(@PathVariable Long id) {
        return pedidoService.listarPedidoPorId(id);
    }

   // @PreAuthorize("hasAnyRole('ADMIN', 'WAITER')")
    @GetMapping("/status")
    public List<PedidoResponse> listarPedidoPorStatus(@RequestParam StatusPedido statusPedido) {
        return pedidoService.listarPorStatus(statusPedido);
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
    }

  //  @PreAuthorize("hasAnyRole('ADMIN', 'WAITER')")
    @PatchMapping("/{id}/status")
    public void atualizarStatusPedido(@PathVariable Long id, @Valid @RequestBody StatusPedidoRequest statusPedidoRequest) {
        pedidoService.atualizarStatusPedido(id, statusPedidoRequest);
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> criarPedido(@RequestBody CriarPedidoRequest request) {

        return ResponseEntity.ok(pedidoService.criarPedido(request));
    }
}
