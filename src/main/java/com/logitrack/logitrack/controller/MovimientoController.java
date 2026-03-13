package com.logitrack.logitrack.controller;

import com.logitrack.logitrack.DTO.request.MovimientoRequestDTO;
import com.logitrack.logitrack.DTO.response.MovimientoResponseDTO;
import com.logitrack.logitrack.service.impl.MovimientoServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/movimiento")
@RequiredArgsConstructor
public class MovimientoController {

    // lógica de negocio
    private final MovimientoServiceImpl movimientoService;

    // Tipo POST /api/movimiento (URL), registra un nuevo movimiento
    @PostMapping
    public ResponseEntity<MovimientoResponseDTO> registrar(@Valid @RequestBody MovimientoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movimientoService.registrar(dto, dto.emailUsuario()));
    }

    // Tipo GET /api/movimiento (URL), devuelve todos los movimientos
    @GetMapping
    public ResponseEntity<List<MovimientoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(movimientoService.buscarTodos());
    }

    // Tipo GET /api/movimiento/1 (URL), devuelve el movimiento con id 1
    @GetMapping("/{id}")
    public ResponseEntity<MovimientoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(movimientoService.buscarPorId(id));
    }

    // Tipo GET /api/movimiento/fechas?inicio=2026-01-01T00:00:00&fin=2026-03-01T00:00:00 (URL)
    // Devuelve los movimientos en ese rango de fechas
    @GetMapping("/fechas")
    public ResponseEntity<List<MovimientoResponseDTO>> buscarPorFechas(
            @RequestParam LocalDateTime inicio,
            @RequestParam LocalDateTime fin) {
        return ResponseEntity.ok(movimientoService.buscarPorRangoDeFechas(inicio, fin));
    }
}