package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.request.ProductoRequestDTO;
import com.logitrack.logitrack.DTO.response.ProductoResponseDTO;
import com.logitrack.logitrack.service.impl.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
@Tag(name = "CATÁLOGO DE PRODUCTOS", description = "Gestiona la lista de artículos que manejas en tu empresa.")
public class ProductoController {

    private final ProductoServiceImpl productoService;

    @Operation(summary = "Crear producto", description = "Añade un artículo nuevo al catálogo. Define su nombre, precio y categoría.")
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> guardar(@Valid @RequestBody ProductoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.guardar(dto));
    }

    @Operation(summary = "Modificar producto", description = "Cambia los detalles de un artículo (como el precio o la descripción).")
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar(@Valid @RequestBody ProductoRequestDTO dto,
                                                          @PathVariable Long id) {
        return ResponseEntity.ok(productoService.actualizar(id, dto));
    }

    @Operation(summary = "Listar catálogo", description = "Mira todos los productos que vendes o manejas.")
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(productoService.buscarTodos());
    }

    @Operation(summary = "Ver un producto", description = "Busca la ficha técnica de un producto por su ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.buscarPorId(id));
    }

    @Operation(summary = "Borrar producto.", description = "Elimina un producto. Solo si no se ha usado nunca en un movimiento de bodega.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}