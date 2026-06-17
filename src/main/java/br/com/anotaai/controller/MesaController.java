package br.com.anotaai.controller;

import br.com.anotaai.dto.request.CriarMesaRequest;
import br.com.anotaai.dto.request.StatusMesaRequest;
import br.com.anotaai.dto.response.MesaResponse;
import br.com.anotaai.entity.Mesa;

import br.com.anotaai.service.MesaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
@RequiredArgsConstructor
public class MesaController {

    private final MesaService mesaService;

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
    public void atualizarStatusMesa(@PathVariable Long id, @Valid @RequestBody StatusMesaRequest statusMesa){
        mesaService.atualizarStatusMesa(id, statusMesa);
    }

    @DeleteMapping("/{id}")
    public void DeletarMesa(@PathVariable Long id){
        mesaService.deletarMesa(id);
    }
}
