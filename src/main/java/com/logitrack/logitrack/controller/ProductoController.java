package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.request.ProductoRequestDTO;
import com.logitrack.logitrack.DTO.response.ProductoResponseDTO;
import com.logitrack.logitrack.service.impl.ProductoServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ProductoController {

    // lógica de negocio
    private final ProductoServiceImpl productoService;

    // Tipo POST /api/producto (URL) crea un nuevo producto
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> guardar(@Valid @RequestBody ProductoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.guardar(dto));
    }

    // Tipo PUT /api/producto/1 (URL), actualiza el producto con id 1
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar(@Valid @RequestBody ProductoRequestDTO dto,
                                                          @PathVariable Long id) {
        return ResponseEntity.ok(productoService.actualizar(id, dto));
    }

    // Tipo GET /api/producto (URL), devuelve todos los productos
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(productoService.buscarTodos());
    }

    // Tipo GET /api/producto/1 (URL), devuelve el producto con id 1
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.buscarPorId(id));
    }

    // Tipo DELETE /api/producto/1 (URL), elimina el producto con id 1
    // Devuelve 204 porque no hay nada que retornar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}