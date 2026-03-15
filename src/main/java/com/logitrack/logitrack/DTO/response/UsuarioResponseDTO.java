package com.logitrack.logitrack.DTO.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record UsuarioResponseDTO(
        @Schema(description = "ID del usuario", example = "5")
        Long id,
        @Schema(description = "Nombre del trabajador", example = "Andrés López")
        String nombreCompleto,
        @Schema(description = "Correo electrónico institucional", example = "andres@logitrack.com")
        String emailInstitucional,
        @Schema(description = "Rol en el sistema", example = "EMPLEADO")
        String rol,
        @Schema(description = "Estado de acceso", example = "true")
        Boolean estaActivo
) {}
