package com.logitrack.logitrack.DTO.response;

public record InventarioResponseDTO(
        Long id,
        BodegaResponseDTO bodega,
        ProductoResponseDTO producto,
        Integer stockActual,
        Integer stockMinimoAlerta
) {}