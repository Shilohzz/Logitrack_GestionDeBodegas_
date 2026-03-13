package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.request.ClienteRequestDTO;
import com.logitrack.logitrack.DTO.response.ClienteResponseDTO;
import com.logitrack.logitrack.service.impl.ClienteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    // Necesito este service para tomar toda la lógica del negocio.
    private final ClienteServiceImpl clienteService;

    // Tipo POST /api/cliente (URL), SE crea un nuevo cliente
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> guardar(@Valid @RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.guardar(dto));
    }

    // Tipo PUT /api/cliente/1 (URL), se actualiza el cliente con id 1
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> actualizar(@Valid @RequestBody ClienteRequestDTO dto,
                                                         @PathVariable Long id) {
        return ResponseEntity.ok(clienteService.actualizar(id, dto));
    }

    // Tipo GET /api/cliente (URL), devuelve todos los clientes
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    // Tipo GET /api/cliente/1 (URL), devuelve el cliente con id 1
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    // Tipo DELETE /api/cliente/1 (URL) elimina el cliente con id 1
    // Devuelve 204 porque no hay nada que retornar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}