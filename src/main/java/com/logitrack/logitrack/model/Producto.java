package com.logitrack.logitrack.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "producto")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Long id;

    @Column(name = "producto_nombre_comercial", nullable = false, length = 150)
    private String nombreComercial;

    @Column(name = "producto_descripcion", length = 255)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_cliente_propietario_id", nullable = false)
    private Cliente clientePropietario;

    @Column(name = "producto_esta_activo", nullable = false)
    private Boolean estaActivo = true;
}