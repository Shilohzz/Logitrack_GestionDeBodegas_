package com.logitrack.logitrack.DTO.response;

import com.logitrack.logitrack.DTO.response.UsuarioResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record AuditoriaResponseDTO(
        @Schema(description = "ID único del registro de auditoría", example = "101")
        Long id,
        @Schema(description = "Acción realizada (INSERT, UPDATE, DELETE)", example = "UPDATE")
        String tipoOperacion,
        @Schema(description = "Fecha y hora exacta del suceso", example = "2026-03-15T15:30:00")
        LocalDateTime fechaHoraExacta,
        @Schema(description = "Usuario que realizó la acción")
        UsuarioResponseDTO usuarioEjecutor,
        @Schema(description = "Tabla o entidad que cambió", example = "PRODUCTO")
        String nombreEntidadAfectada,
        @Schema(description = "ID del registro que fue modificado", example = "25")
        Long idRegistroAfectado,
        @Schema(description = "Estado del dato antes del cambio")
        String valoresAnteriores,
        @Schema(description = "Estado del dato después del cambio")
        String valoresNuevos
) {}