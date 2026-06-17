package br.com.anotaai.controller;

import br.com.anotaai.dto.StatusMesaMesaRequest;
import br.com.anotaai.entity.Mesa;

import br.com.anotaai.service.MesaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")

public class MesaController {

    private final MesaService mesaService;
    

    public MesaController(MesaService mesaService) {
		this.mesaService = mesaService;
	}
	@PostMapping
    public ResponseEntity<MesaResponse> salvarMesa(@Valid @RequestBody CriarMesaRequest criarMesaRequest){
        MesaResponse mesaResponse = mesaService.salvarMesa(criarMesaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(mesaResponse);
    }
	@GetMapping
    public List<Mesa> listarMesas() {
        return mesaService.listarMesas();
    }

    @GetMapping("/{id}")
    public Mesa listarMesaPorId(@PathVariable Long id){
        return mesaService.buscarMesaPorId(id);
    }

    @PatchMapping("/{id}/status")
    public void atualizarStatusMesa(@PathVariable Long id, @RequestBody StatusMesaMesaRequest statusMesa){
        mesaService.atualizarStatusMesa(id, statusMesa);
    }

    @DeleteMapping("/{id}")
    public void DeletarMesa(@PathVariable Long id){
        mesaService.deletarMesa(id);
    }
}
