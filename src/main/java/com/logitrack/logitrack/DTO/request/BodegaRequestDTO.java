package com.logitrack.logitrack.DTO.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BodegaRequestDTO(
        @NotBlank(message = "El nombre de la bodega no puede estar vacío.")
        @Size(min = 2, max = 120, message = "El nombre debe tener entre 2 y 120 caracteres.")
        String nombreComercial,

        @NotBlank(message = "La ciudad no puede estar vacía.")
        String ciudadUbicacion,

        @NotBlank(message = "La dirección no puede estar vacía.")
        String direccionExacta,

        @NotNull(message = "La capacidad no puede ser nula.")
        @Min(value = 1, message = "La capacidad debe ser mayor a 0.")
        Integer capacidadMaximaUnidades,

        @NotNull(message = "Debe haber un encargado en bodega.")
        Long encargadoId
) {}