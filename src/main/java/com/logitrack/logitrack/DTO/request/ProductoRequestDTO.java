package com.logitrack.logitrack.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductoRequestDTO(
        @NotBlank(message = "El nombre del producto no puede estar vacío.")
        @Size(min = 2, max = 150, message = "El nombre debe tener entre 2 y 150 caracteres.")
        String nombreComercial,

        @Size(max = 255, message = "La descripción no puede superar 255 caracteres.")
        String descripcion,

        @NotNull(message = "La categoría no puede ser nula.")
        Long categoriaId,

        @NotNull(message = "El cliente propietario no puede ser nulo.")
        Long clientePropietarioId
) {}