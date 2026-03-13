package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.request.CategoriaRequestDTO;
import com.logitrack.logitrack.DTO.response.CategoriaResponseDTO;
import com.logitrack.logitrack.service.impl.CategoriaServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Para recibir solicitudes HTTP y devolver JSON
@RequestMapping("/api/categoria") // Defino el inicio de la ruta de este controller.
@RequiredArgsConstructor //
public class CategoriaController {


    private final CategoriaServiceImpl categoriaService;


    // Uso Valid para verificar por ejemplo (@NotBlank, @Size, etc)
    // Uso RequestBody para convertir el JSON que trae CategoriaRequestDTO
    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> guardar(@Valid @RequestBody CategoriaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.guardar(dto));
    }


    @PutMapping("/{id}") // en id irá el id punico de la categoria
    public ResponseEntity<CategoriaResponseDTO> actualizar(@Valid @RequestBody CategoriaRequestDTO dto,
                                                           @PathVariable Long id) // Uso PathVariable para capturar el id de la url
    {

        return ResponseEntity.ok(categoriaService.actualizar(id, dto));
    }


    // Tipo Get  /api/categoria
    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(categoriaService.buscarTodos());
    }


    // Tipo Get /api/categoria/1
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }


    // Tipo Get /api/categoria/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}