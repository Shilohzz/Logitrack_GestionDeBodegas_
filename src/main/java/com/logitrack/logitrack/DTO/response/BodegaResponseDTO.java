package com.logitrack.logitrack.DTO.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record BodegaResponseDTO(
        @Schema(description = "ID de la bodega", example = "1")
        Long id,
        @Schema(description = "Nombre comercial", example = "Almacén Central")
        String nombreComercial,
        @Schema(description = "Ciudad de ubicación", example = "Bucaramanga")
        String ciudadUbicacion,
        @Schema(description = "Dirección física", example = "Calle 45 #23-10")
        String direccionExacta,
        @Schema(description = "Capacidad máxima permitida", example = "5000")
        Integer capacidadMaximaUnidades,
        @Schema(description = "Datos del encargado actual")
        UsuarioResponseDTO encargado,
        @Schema(description = "Indica si la bodega está operativa", example = "true")
        Boolean estaActiva
) {}