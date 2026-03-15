package com.logitrack.logitrack.DTO.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BodegaRequestDTO(
        @Schema(description = "Nombre comercial de la bodega", example = "Bodega Central")
        @NotBlank(message = "El nombre de la bodega no puede estar vacío.")
        @Size(min = 2, max = 120, message = "El nombre debe tener entre 2 y 120 caracteres.")
        String nombreComercial,

        @Schema(description = "Ciudad donde se ubica", example = "Bucaramanga")
        @NotBlank(message = "La ciudad no puede estar vacía.")
        String ciudadUbicacion,

        @Schema(description = "Dirección física", example = "Calle 10 #15-20")
        @NotBlank(message = "La dirección no puede estar vacía.")
        String direccionExacta,

        @Schema(description = "Capacidad total de almacenamiento", example = "1000")
        @NotNull(message = "La capacidad no puede ser nula.")
        @Min(value = 1, message = "La capacidad debe ser mayor a 0.")
        Integer capacidadMaximaUnidades,

        @Schema(description = "ID del usuario encargado", example = "1")
        @NotNull(message = "Debe haber un encargado en bodega.")
        Long encargadoId
) {}