package com.logitrack.logitrack.DTO.response;

import java.time.LocalDateTime;
import java.util.List;

public record MovimientoResponseDTO(
        Long id,
        LocalDateTime fechaHora,
        String tipo,
        UsuarioResponseDTO usuarioResponsable,
        BodegaResponseDTO bodegaOrigen,
        BodegaResponseDTO bodegaDestino,
        String observacion,
        List<MovimientoDetalleResponseDTO> detalles
) {}