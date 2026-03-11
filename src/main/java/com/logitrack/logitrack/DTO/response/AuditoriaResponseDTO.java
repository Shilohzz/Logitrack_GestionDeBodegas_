package com.logitrack.logitrack.DTO.response;

import com.logitrack.logitrack.DTO.response.UsuarioResponseDTO;

import java.time.LocalDateTime;

public record AuditoriaResponseDTO(
        Long id,
        String tipoOperacion,
        LocalDateTime fechaHoraExacta,
        UsuarioResponseDTO usuarioEjecutor,
        String nombreEntidadAfectada,
        Long idRegistroAfectado,
        String valoresAnteriores,
        String valoresNuevos
) {}