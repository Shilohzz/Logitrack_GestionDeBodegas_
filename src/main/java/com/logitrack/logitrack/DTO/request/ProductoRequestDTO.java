package com.logitrack.logitrack.DTO.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductoRequestDTO(
        @Schema(description = "Nombre del artículo", example = "Teclado Mecánico")
        @NotBlank(message = "El nombre del producto no puede estar vacío.")
        @Size(min = 2, max = 150, message = "El nombre debe tener entre 2 y 150 caracteres.")
        String nombreComercial,

        @Schema(description = "Descripción técnica", example = "Teclado RGB switch azul")
        @Size(max = 255, message = "La descripción no puede superar 255 caracteres.")
        String descripcion,

        @Schema(description = "ID de su categoría", example = "1")
        @NotNull(message = "La categoría no puede ser nula.")
        Long categoriaId,

        @Schema(description = "ID del cliente dueño del producto", example = "1")
        @NotNull(message = "El cliente propietario no puede ser nulo.")
        Long clientePropietarioId
) {}