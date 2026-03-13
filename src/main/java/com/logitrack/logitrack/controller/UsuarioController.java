package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.request.UsuarioRequestDTO;
import com.logitrack.logitrack.DTO.response.UsuarioResponseDTO;
import com.logitrack.logitrack.service.impl.UsuarioServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    // lógica de negocio
    private final UsuarioServiceImpl usuarioService;

    // Tipo POST /api/usuario (URL), crea un nuevo usuario
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> guardar(@Valid @RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(dto));
    }

    // Tipo PUT /api/usuario/1 (URL), actualiza el usuario con id 1
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> actualizar(@Valid @RequestBody UsuarioRequestDTO dto,
                                                         @PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.actualizar(id, dto));
    }

    // Tipo GET /api/usuario (URL), devuelve todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    // Tipo GET /api/usuario/1 (URL), devuelve el usuario con id 1
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    // Tipo DELETE /api/usuario/1 (URL), elimina el usuario con id 1
    // Devuelve 204 porque no hay nada que retornar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}