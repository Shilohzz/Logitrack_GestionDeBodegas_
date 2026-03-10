package com.logitrack.logitrack.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "usuario_nombre_completo", nullable = false, length = 150)
    private String nombreCompleto;

    @Column(name = "usuario_email_institucional", nullable = false, unique = true, length = 120)
    private String emailInstitucional;

    @Column(name = "usuario_contrasena_hash", nullable = false, length = 255)
    private String contrasenaHash;

    @Column(name = "usuario_rol", nullable = false)
    private String rol;

    @Column(name = "usuario_esta_activo", nullable = false)
    private Boolean estaActivo = true;
}
