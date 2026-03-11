package com.logitrack.logitrack.DTO.response;

public record ClienteResponseDTO(
        Long id,
        String nombreCompleto,
        String tipo,
        String numeroDocumento,
        String emailContacto,
        String telefonoContacto,
        String direccionPrincipal,
        Boolean estaActivo
) {}