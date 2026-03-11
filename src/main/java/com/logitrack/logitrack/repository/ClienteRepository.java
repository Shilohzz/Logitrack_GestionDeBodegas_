package com.logitrack.logitrack.repository;

import com.logitrack.logitrack.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}