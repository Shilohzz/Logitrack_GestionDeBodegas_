package com.logitrack.logitrack.DTO.response;

public record BodegaResponseDTO(
        Long id,
        String nombreComercial,
        String ciudadUbicacion,
        String direccionExacta,
        Integer capacidadMaximaUnidades,
        UsuarioResponseDTO encargado,
        Boolean estaActiva
) {}