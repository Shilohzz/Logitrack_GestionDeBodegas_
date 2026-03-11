package com.logitrack.logitrack.DTO.response;

public record UsuarioResponseDTO(
        Long id,
        String nombreCompleto,
        String emailInstitucional,
        String rol,
        Boolean estaActivo
) {}