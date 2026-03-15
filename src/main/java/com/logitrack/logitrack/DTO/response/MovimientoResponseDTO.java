package com.logitrack.logitrack.DTO.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

public record MovimientoResponseDTO(
        @Schema(description = "ID de la operación", example = "500")
        Long id,
        @Schema(description = "Fecha y hora del movimiento", example = "2026-03-15T10:00:00")
        LocalDateTime fechaHora,
        @Schema(description = "Tipo de movimiento realizado", example = "TRANSFERENCIA")
        String tipo,
        @Schema(description = "Empleado o Admin que lo registró")
        UsuarioResponseDTO usuarioResponsable,
        @Schema(description = "Bodega de donde salió (nulo si es ENTRADA)")
        BodegaResponseDTO bodegaOrigen,
        @Schema(description = "Bodega a donde entró (nulo si es SALIDA)")
        BodegaResponseDTO bodegaDestino,
        @Schema(description = "Comentarios adicionales", example = "Traslado por stock bajo en sede B")
        String observacion,
        @Schema(description = "Lista detallada de productos movidos")
        List<MovimientoDetalleResponseDTO> detalles
) {}