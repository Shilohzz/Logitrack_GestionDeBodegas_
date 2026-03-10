package com.logitrack.logitrack.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventario")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventario_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventario_bodega_id", nullable = false)
    private Bodega bodega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventario_producto_id", nullable = false)
    private Producto producto;

    @Column(name = "inventario_stock_actual", nullable = false)
    private Integer stockActual = 0;

    @Column(name = "inventario_stock_minimo_alerta", nullable = false)
    private Integer stockMinimoAlerta = 10;
}