package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.request.BodegaRequestDTO;
import com.logitrack.logitrack.DTO.response.BodegaResponseDTO;
import com.logitrack.logitrack.service.impl.BodegaServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bodega")
@RequiredArgsConstructor
public class BodegaController {

    // Lógica de negocio
    private final BodegaServiceImpl bodegaService;

    // Tipo POST /api/bodega (URL), crea una nueva bodega
    @PostMapping
    public ResponseEntity<BodegaResponseDTO> guardar(@Valid @RequestBody BodegaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bodegaService.guardar(dto));
    }

    // Tipo PUT /api/bodega/1 (URL) actualiza la bodega con id 1
    @PutMapping("/{id}")
    public ResponseEntity<BodegaResponseDTO> actualizar(@Valid @RequestBody BodegaRequestDTO dto,
                                                        @PathVariable Long id) {
        return ResponseEntity.ok(bodegaService.actualizar(id, dto));
    }

    // Tipo GET /api/bodega (URL), devuelve todas las bodegas
    @GetMapping
    public ResponseEntity<List<BodegaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(bodegaService.buscarTodos());
    }

    // Tipo GET /api/bodega/1 (URL), devuelve la bodega con id 1
    @GetMapping("/{id}")
    public ResponseEntity<BodegaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(bodegaService.buscarPorId(id));
    }

    // Tipo DELETE /api/bodega/1 (URL), elimina la bodega con id 1
    // Devuelve 204 porque no hay nada que retornar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        bodegaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}