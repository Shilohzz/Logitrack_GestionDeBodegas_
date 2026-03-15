package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.response.AuditoriaResponseDTO;
import com.logitrack.logitrack.service.impl.AuditoriaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/auditoria")
@RequiredArgsConstructor
@Tag(name = "AUDITORÍA", description = "Aquí puedes revisar quién hizo qué en el sistema. Es el historial de seguridad de la aplicación.")
public class AuditoriaController {

    // lógica de negocio
    private final AuditoriaServiceImpl auditoriaService;

    // Tipo GET /api/auditoria (URL), devuelve todas las auditorías
    @Operation(summary = "Ver todo el historial", description = "Te devuelve una lista gigante con todos los movimientos y cambios registrados.")
    @GetMapping
    public ResponseEntity<List<AuditoriaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(auditoriaService.buscarTodos());
    }

    // Tipo GET /api/auditoria/1 (URL), devuelve la auditoría con id 1
    @Operation(summary = "Ver un registro específico", description = "Busca un evento puntual usando su ID.")
    @GetMapping("/{id}")
    public ResponseEntity<AuditoriaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(auditoriaService.buscarPorId(id));
    }

    // Tipo GET /api/auditoria/usuario/1 (URL), devuelve auditorías del usuario con id 1
    @Operation(summary = "Ver qué hizo un usuario", description = "Filtra el historial para ver solo las acciones de una persona específica.")
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<AuditoriaResponseDTO>> buscarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(auditoriaService.buscarPorUsuario(usuarioId));
    }

    // Tipo GET /api/auditoria/tipo?operacion=INSERT (URL)
    // Devuelve auditorías filtradas por tipo de operación
    @Operation(summary = "Filtrar por tipo de acción", description = "Busca solo los registros de creación (INSERT), actualización (UPDATE) o eliminación (DELETE).")
    @GetMapping("/tipo")
    public ResponseEntity<List<AuditoriaResponseDTO>> buscarPorTipo(@RequestParam String operacion) {
        return ResponseEntity.ok(auditoriaService.buscarPorTipoOperacion(operacion));
    }
}