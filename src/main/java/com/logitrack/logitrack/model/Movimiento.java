package com.logitrack.logitrack.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movimiento_id")
    private Long id;

    @Column(name = "movimiento_fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "movimiento_tipo", nullable = false)
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movimiento_usuario_responsable_id", nullable = false)
    private Usuario usuarioResponsable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movimiento_bodega_origen_id")
    private Bodega bodegaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movimiento_bodega_destino_id")
    private Bodega bodegaDestino;

    @Column(name = "movimiento_observacion", length = 500)
    private String observacion;
}