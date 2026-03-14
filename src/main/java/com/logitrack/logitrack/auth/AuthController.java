package com.logitrack.logitrack.auth;

import com.logitrack.logitrack.config.JwtService;
import com.logitrack.logitrack.auth.LoginRequest;
import com.logitrack.logitrack.auth.LoginResponse;
import com.logitrack.logitrack.exception.BusinessRuleException;
import com.logitrack.logitrack.model.Usuario;
import com.logitrack.logitrack.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        // Busco el usuario en BD
        Usuario usuario = usuarioRepository.findByEmailInstitucional(request.email())
                .orElseThrow(() -> new BusinessRuleException("Las credenciales son inválidas"));

        // Comparo la contraseña que recibí, con el hash que está en la base de datos
        if (!passwordEncoder.matches(request.password(), usuario.getContrasenaHash())) {
            throw new BusinessRuleException("Las credenciales son inválidas");
        }

        // Miro que el usuario esté activo y sino le lanza un error
        if (!usuario.getEstaActivo()) {
            throw new BusinessRuleException("El usuario está inactivo");
        }

        // Si todo lo anterior sale bien, creo el token con el email del usuario y lo devuelvo al frontend
        String token = jwtService.generateToken(usuario.getEmailInstitucional(), usuario.getRol());
        return ResponseEntity.ok(new LoginResponse(token));
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LoginRequest request) {
        // Miro que el email no esté ya registrado, como la consulta JPA me da un Optional,
        // le especifíco que quiero saber si existe o no con "isPresent()"
        if (usuarioRepository.findByEmailInstitucional(request.email()).isPresent()) {
            throw new BusinessRuleException("El email ya está registrado");
        }

        // Creo el usuario con los datos recibidos
        Usuario usuario = new Usuario();
        usuario.setEmailInstitucional(request.email());

        // Aquí es donde cifro la contrasenha antes de guardarla en BD
        usuario.setContrasenaHash(passwordEncoder.encode(request.password()));

        usuario.setNombreCompleto(request.email());
        usuario.setRol(request.rol());
        usuarioRepository.save(usuario); // Guardo el usuario creado en la BD

        return ResponseEntity.ok("Usuario registrado exitosamente");
    }
}