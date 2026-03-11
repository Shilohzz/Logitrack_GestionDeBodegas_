package com.logitrack.logitrack.DTO.response;

public record MovimientoDetalleResponseDTO(
        Long id,
        ProductoResponseDTO producto,
        Integer cantidadUnidades
) {}