package com.logitrack.logitrack.DTO.response;

public record ProductoResponseDTO(
        Long id,
        String nombreComercial,
        String descripcion,
        CategoriaResponseDTO categoria,
        ClienteResponseDTO clientePropietario,
        Boolean estaActivo
) {}