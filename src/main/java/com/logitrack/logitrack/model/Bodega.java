package com.logitrack.logitrack.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bodega")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bodega_id")
    private Long id;

    @Column(name = "bodega_nombre_comercial", nullable = false, length = 120)
    private String nombreComercial;

    @Column(name = "bodega_ciudad_ubicacion", nullable = false, length = 100)
    private String ciudadUbicacion;

    @Column(name = "bodega_direccion_exacta", nullable = false, length = 255)
    private String direccionExacta;

    @Column(name = "bodega_capacidad_maxima_unidades", nullable = false)
    private Integer capacidadMaximaUnidades;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bodega_encargado_usuario_id", nullable = false)
    private Usuario encargado;

    @Column(name = "bodega_esta_activa", nullable = false)
    private Boolean estaActiva = true;
}