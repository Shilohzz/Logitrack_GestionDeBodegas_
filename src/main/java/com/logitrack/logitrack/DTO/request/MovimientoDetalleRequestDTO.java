package com.logitrack.logitrack.DTO.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record MovimientoDetalleRequestDTO(
        @Schema(description = "ID del producto a mover", example = "5")
        @NotNull(message = "El producto no puede ser nulo.")
        Long productoId,

        @Schema(description = "Cantidad de unidades", example = "10")
        @NotNull(message = "La cantidad no puede ser nula.")
        @Min(value = 1, message = "La cantidad debe ser mayor a 0.")
        Integer cantidadUnidades
) {}
