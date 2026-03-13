package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.response.InventarioResponseDTO;
import com.logitrack.logitrack.service.impl.InventarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class InventarioController {

    // lógica de negocio
    private final InventarioServiceImpl inventarioService;

    // Tipo GET /api/inventario (URL), devuelve todos los inventarios
    @GetMapping
    public ResponseEntity<List<InventarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(inventarioService.buscarTodos());
    }

    // Tipo GET /api/inventario/1 (URL), devuelve el inventario con id 1
    @GetMapping("/{id}")
    public ResponseEntity<InventarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(inventarioService.buscarPorId(id));
    }

    // Tipo GET /api/inventario/stock-bajo (URL), devuelve productos con stock menor a 10
    @GetMapping("/stock-bajo")
    public ResponseEntity<List<InventarioResponseDTO>> stockBajo() {
        return ResponseEntity.ok(inventarioService.buscarStockBajo());
    }
}