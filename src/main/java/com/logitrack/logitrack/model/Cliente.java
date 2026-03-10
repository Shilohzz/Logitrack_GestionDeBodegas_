package com.logitrack.logitrack.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;

    @Column(name = "cliente_nombre_completo", nullable = false, length = 150)
    private String nombreCompleto;

    @Column(name = "cliente_tipo", nullable = false)
    private String tipo;

    @Column(name = "cliente_numero_documento", nullable = false, unique = true, length = 30)
    private String numeroDocumento;

    @Column(name = "cliente_email_contacto", length = 120)
    private String emailContacto;

    @Column(name = "cliente_telefono_contacto", length = 20)
    private String telefonoContacto;

    @Column(name = "cliente_direccion_principal", length = 255)
    private String direccionPrincipal;

    @Column(name = "cliente_esta_activo", nullable = false)
    private Boolean estaActivo = true;
}