package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.request.ClienteRequestDTO;
import com.logitrack.logitrack.DTO.response.ClienteResponseDTO;
import com.logitrack.logitrack.service.impl.ClienteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
@Tag(name = "GESTION CLIENTES", description = "Gestiona la información de las personas o empresas que reciben tu mercancía.")
public class ClienteController {

    private final ClienteServiceImpl clienteService;

    @Operation(summary = "Registrar cliente", description = "Guarda los datos de un nuevo cliente en tu base de datos.")
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> guardar(@Valid @RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.guardar(dto));
    }

    @Operation(summary = "Actualizar cliente", description = "Cambia el teléfono, dirección o nombre de un cliente.")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> actualizar(@Valid @RequestBody ClienteRequestDTO dto,
                                                         @PathVariable Long id) {
        return ResponseEntity.ok(clienteService.actualizar(id, dto));
    }

    @Operation(summary = "Listar clientes", description = "Muestra una lista con todos tus clientes registrados.")
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @Operation(summary = "Buscar cliente", description = "Obtén la ficha completa de un cliente por su ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @Operation(summary = "Eliminar cliente", description = "Quita a un cliente del sistema. Solo podrás hacerlo si no tiene movimientos asociados.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}