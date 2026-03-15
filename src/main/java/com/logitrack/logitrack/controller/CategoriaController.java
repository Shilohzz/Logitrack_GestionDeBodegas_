package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.request.CategoriaRequestDTO;
import com.logitrack.logitrack.DTO.response.CategoriaResponseDTO;
import com.logitrack.logitrack.service.impl.CategoriaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@RequiredArgsConstructor
@Tag(name = "CATEGORIAS DE PRODUCTOS", description = "Organiza tus productos por grupos (ej: Electrónica, Aseo, Alimentos) para encontrarlos más fácil.")
public class CategoriaController {

    private final CategoriaServiceImpl categoriaService;

    @Operation(summary = "Crear categoría", description = "Añade un nuevo grupo para clasificar tus productos.")
    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> guardar(@Valid @RequestBody CategoriaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.guardar(dto));
    }

    @Operation(summary = "Editar categoría", description = "Cambia el nombre o la descripción de una categoría que ya existe.")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> actualizar(@Valid @RequestBody CategoriaRequestDTO dto,
                                                           @PathVariable Long id)
    {
        return ResponseEntity.ok(categoriaService.actualizar(id, dto));
    }

    @Operation(summary = "Listar todas", description = "Mira todos los grupos de productos que tienes creados.")
    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(categoriaService.buscarTodos());
    }

    @Operation(summary = "Ver una categoría", description = "Mira el detalle de una sola categoría usando su ID.")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    @Operation(summary = "Borrar categoría", description = "Elimina un grupo. ¡Ojo! No podrás borrarla si todavía tiene productos asociados.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}