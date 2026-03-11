package com.logitrack.logitrack.repository;

import com.logitrack.logitrack.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);
}