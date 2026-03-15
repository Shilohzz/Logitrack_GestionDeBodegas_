package com.logitrack.logitrack.DTO.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record InventarioResponseDTO(
        @Schema(description = "ID del registro de inventario", example = "50")
        Long id,
        @Schema(description = "Bodega donde se encuentra el stock")
        BodegaResponseDTO bodega,
        @Schema(description = "Producto almacenado")
        ProductoResponseDTO producto,
        @Schema(description = "Cantidad disponible actualmente", example = "120")
        Integer stockActual,
        @Schema(description = "Punto de reorden para alertas", example = "10")
        Integer stockMinimoAlerta
) {}