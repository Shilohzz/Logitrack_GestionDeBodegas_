package com.logitrack.logitrack.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditoria_id")
    private Long id;

    @Column(name = "auditoria_tipo_operacion", nullable = false)
    private String tipoOperacion;

    @Column(name = "auditoria_fecha_hora_exacta", nullable = false)
    private LocalDateTime fechaHoraExacta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditoria_usuario_ejecutor_id")
    private Usuario usuarioEjecutor;

    @Column(name = "auditoria_nombre_entidad_afectada", nullable = false, length = 60)
    private String nombreEntidadAfectada;

    @Column(name = "auditoria_id_registro_afectado", nullable = false)
    private Long idRegistroAfectado;

    @Column(name = "auditoria_valores_anteriores", length = 500)
    private String valoresAnteriores;

    @Column(name = "auditoria_valores_nuevos", length = 500)
    private String valoresNuevos;
}