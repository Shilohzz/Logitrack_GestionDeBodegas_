package com.logitrack.logitrack.DTO.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record CategoriaResponseDTO(
        @Schema(description = "ID de la categoría", example = "1")
        Long id,
        @Schema(description = "Nombre del grupo", example = "Tecnología")
        String nombre,
        @Schema(description = "Descripción de la categoría", example = "Equipos electrónicos y accesorios")
        String descripcion
) {}