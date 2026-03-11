package com.logitrack.logitrack.repository;

import com.logitrack.logitrack.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    Optional<Inventario> findByBodegaIdAndProductoId(Long bodegaId, Long productoId);
    List<Inventario> findByStockActualLessThan(Integer stock);
}