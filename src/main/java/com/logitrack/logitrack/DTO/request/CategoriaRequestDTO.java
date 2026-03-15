package com.logitrack.logitrack.DTO.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaRequestDTO(
        @Schema(description = "Nombre de la categoría", example = "Electrónicos")
        @NotBlank(message = "El nombre no puede quedar vacío")
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        String nombre,

        @Schema(description = "Descripción del tipo de productos", example = "Artículos de tecnología y oficina")
        @Size(max = 250, message = "La descripción es demasiado larga. No puede ser soportada")
        String descripcion
) {}
