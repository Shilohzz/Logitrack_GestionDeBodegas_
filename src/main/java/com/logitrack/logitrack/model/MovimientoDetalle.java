package com.logitrack.logitrack.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movimiento_detalle")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class MovimientoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detalle_movimiento_id", nullable = false)
    private Movimiento movimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detalle_producto_id", nullable = false)
    private Producto producto;

    @Column(name = "detalle_cantidad_unidades", nullable = false)
    private Integer cantidadUnidades;
}