package com.logitrack.logitrack.DTO.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteRequestDTO(
        @Schema(description = "Nombre completo o razón social", example = "Juan Pérez")
        @NotBlank(message = "El nombre no puede estar vacío.")
        @Size(min = 2, max = 150, message = "el nombre debe tener entre 2 y 150 caracteres.")
        String nombreCompleto,

        @Schema(description = "Tipo de cliente", example = "EMPRESARIO")
        @NotBlank(message = "Debes asignar el tipo de cliente (PERSONA_NATURAL/EMPRESARIO).")
        String tipo,

        @Schema(description = "Cédula o NIT", example = "123456789")
        @NotBlank(message = "El cliente debe tener un documento de identificación único.")
        String numeroDocumento,

        @Schema(description = "Correo electrónico", example = "cliente@correo.com")
        @NotBlank(message = "El cliente debe tener un email de contacto.")
        String emailContacto,

        @Schema(description = "Teléfono", example = "3001234567")
        @NotBlank(message = "El cliente debe tener un teléfono de contacto.")
        String telefonoContacto,

        @Schema(description = "Dirección de residencia o sede", example = "Carrera 5 #10-30")
        @NotBlank(message = "El cliente debe tener una dirección única.")
        String direccionPrincipal
) {}
