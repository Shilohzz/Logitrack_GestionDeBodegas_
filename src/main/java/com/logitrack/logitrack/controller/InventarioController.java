package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.response.InventarioResponseDTO;
import com.logitrack.logitrack.service.impl.InventarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
@Tag(name = "CONSULTA DE INVENTARIO", description = "Mira cuánto tienes de cada cosa y en qué bodega está guardado.")
public class InventarioController {

    private final InventarioServiceImpl inventarioService;

    @Operation(summary = "Ver todo el stock", description = "Muestra la cantidad actual de todos los productos en todas las bodegas.")
    @GetMapping
    public ResponseEntity<List<InventarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(inventarioService.buscarTodos());
    }

    @Operation(summary = "Consultar stock específico", description = "Mira la cantidad de un producto puntual en una bodega específica usando el ID del registro.")
    @GetMapping("/{id}")
    public ResponseEntity<InventarioResponseDTO>buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(inventarioService.buscarPorId(id));
    }

    @Operation(summary = "¡Alerta de Stock Bajo!", description = "Muestra los productos que tienen menos de 10 unidades. ¡Corre a reabastecer!")
    @GetMapping("/stock-bajo")
    public ResponseEntity<List<InventarioResponseDTO>> stockBajo() {
        return ResponseEntity.ok(inventarioService.buscarStockBajo());
    }
}