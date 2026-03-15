package com.logitrack.logitrack.DTO.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record ProductoResponseDTO(
        @Schema(description = "ID del producto", example = "25")
        Long id,
        @Schema(description = "Nombre del artículo", example = "Monitor 24 Pulgadas")
        String nombreComercial,
        @Schema(description = "Detalles técnicos", example = "Full HD, HDMI, 75Hz")
        String descripcion,
        @Schema(description = "Categoría asociada")
        CategoriaResponseDTO categoria,
        @Schema(description = "Dueño de la mercancía")
        ClienteResponseDTO clientePropietario,
        @Schema(description = "Estado en el catálogo", example = "true")
        Boolean estaActivo
) {}