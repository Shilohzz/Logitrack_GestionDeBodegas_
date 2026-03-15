package com.logitrack.logitrack.DTO.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record ClienteResponseDTO(
        @Schema(description = "ID del cliente", example = "1")
        Long id,
        @Schema(description = "Nombre o Razón Social", example = "Logística S.A.")
        String nombreCompleto,
        @Schema(description = "Tipo de cliente registrado", example = "EMPRESARIO")
        String tipo,
        @Schema(description = "Documento de identidad", example = "900123456")
        String numeroDocumento,
        @Schema(description = "Correo de contacto", example = "ventas@logistica.com")
        String emailContacto,
        @Schema(description = "Teléfono de contacto", example = "3151234567")
        String telefonoContacto,
        @Schema(description = "Dirección registrada", example = "Avenida Central #10")
        String direccionPrincipal,
        @Schema(description = "Estado de la cuenta del cliente", example = "true")
        Boolean estaActivo
) {}