package com.logitrack.logitrack.DTO.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public record MovimientoRequestDTO(
        @Schema(description = "Tipo de movimiento", example = "ENTRADA")
        @NotBlank(message = "El tipo de movimiento no puede estar vacío")
        String tipo,

        @Schema(description = "ID bodega de origen", example = "1")
        Long bodegaOrigenId,

        @Schema(description = "ID bodega de destino", example = "2")
        Long bodegaDestinoId,

        @Schema(description = "Email del usuario que registra", example = "empleado@logitrack.com")
        @NotBlank(message = "El email del usuario no puede estar vacío")
        String emailUsuario,

        @Schema(description = "Notas adicionales", example = "Ingreso por compra a proveedor")
        @Size(max = 500, message = "La observación no puede superar 500 caracteres")
        String observacion,

        @Schema(description = "Lista de productos incluidos")
        @NotNull(message = "Debe incluir al menos un producto")
        List<MovimientoDetalleRequestDTO> detalles
) {}