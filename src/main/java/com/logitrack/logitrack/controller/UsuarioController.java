package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.request.UsuarioRequestDTO;
import com.logitrack.logitrack.DTO.response.UsuarioResponseDTO;
import com.logitrack.logitrack.service.impl.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
@Tag(name = "CONTROL DE USUARIOS", description = "CRUD para los usuarios.")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    @Operation(summary = "Registrar usuario", description = "Crea una nueva cuenta de acceso para un trabajador.")
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> guardar(@Valid @RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(dto));
    }

    @Operation(summary = "Editar usuario", description = "Actualiza los datos personales o el rol de un usuario.")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> actualizar(@Valid @RequestBody UsuarioRequestDTO dto,
                                                         @PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.actualizar(id, dto));
    }

    @Operation(summary = "Ver lista de usuarios", description = "Muestra a todas las personas que tienen acceso al sistema.")
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @Operation(summary = "Buscar usuario", description = "Obtén el perfil de un usuario específico por su ID.")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @Operation(summary = "Eliminar usuario.", description = "Elimina el acceso de un usuario al sistema.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}