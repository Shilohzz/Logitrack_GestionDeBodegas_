package com.logitrack.logitrack.service;

import com.logitrack.logitrack.DTO.request.UsuarioRequestDTO;
import com.logitrack.logitrack.DTO.response.UsuarioResponseDTO;
import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO guardar(UsuarioRequestDTO dto);
    UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO dto);
    UsuarioResponseDTO buscarPorId(Long id);
    List<UsuarioResponseDTO> buscarTodos();
    void eliminar(Long id);
}