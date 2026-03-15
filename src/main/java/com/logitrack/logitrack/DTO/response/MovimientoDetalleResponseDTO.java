package com.logitrack.logitrack.DTO.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record MovimientoDetalleResponseDTO(
        @Schema(description = "ID del detalle", example = "1000")
        Long id,
        @Schema(description = "Producto involucrado")
        ProductoResponseDTO producto,
        @Schema(description = "Cantidad movida", example = "15")
        Integer cantidadUnidades
) {}