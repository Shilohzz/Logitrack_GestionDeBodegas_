package com.logitrack.logitrack.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public record MovimientoRequestDTO(
        @NotBlank(message = "El tipo de movimiento no puede estar vacío")
        String tipo,

        Long bodegaOrigenId,
        Long bodegaDestinoId,

        @NotBlank(message = "El email del usuario no puede estar vacío")
        String emailUsuario,

        @Size(max = 500, message = "La observación no puede superar 500 caracteres")
        String observacion,

        @NotNull(message = "Debe incluir al menos un producto")
        List<MovimientoDetalleRequestDTO> detalles
) {}