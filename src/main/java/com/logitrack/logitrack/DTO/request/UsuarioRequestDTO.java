package com.logitrack.logitrack.DTO.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(
        @Schema(description = "Nombre del usuario", example = "Carlos Ruiz")
        @NotBlank(message = "El nombre completo no puede estar vacío.")
        @Size(min = 2, max = 150, message = "El nombre debe tener entre 2 y 150 caracteres.")
        String nombreCompleto,

        @Schema(description = "Correo institucional", example = "carlos@logitrack.com")
        @NotBlank(message = "El email no puede estar vacío.")
        String emailInstitucional,

        @Schema(description = "Contraseña de acceso", example = "123456")
        @NotBlank(message = "La contraseña no puede estar vacía.")
        @Size(min = 6, message = "La contraseña debe tener mínimo 6 caracteres.")
        String contrasena,

        @Schema(description = "Rol asignado", example = "ADMIN")
        @NotBlank(message = "El rol no puede estar vacío.")
        String rol
) {}
