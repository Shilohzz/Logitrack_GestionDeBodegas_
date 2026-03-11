package com.logitrack.logitrack.DTO.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record MovimientoDetalleRequestDTO(
        @NotNull(message = "El producto no puede ser nulo.")
        Long productoId,

        @NotNull(message = "La cantidad no puede ser nula.")
        @Min(value = 1, message = "La cantidad debe ser mayor a 0.")
        Integer cantidadUnidades
) {}
