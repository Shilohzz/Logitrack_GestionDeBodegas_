package com.logitrack.logitrack.repository;

import com.logitrack.logitrack.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}