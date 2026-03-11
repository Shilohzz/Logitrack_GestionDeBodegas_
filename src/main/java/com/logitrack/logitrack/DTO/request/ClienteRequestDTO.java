package com.logitrack.logitrack.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteRequestDTO(
   @NotBlank(message = "El nombre no puede estar vacío.")
   @Size(min = 2, max = 150, message = "el nombre debe tener entre 2 y 150 caracteres.")
   String nombreCompleto,

   @NotBlank(message = "Debes asignar el tipo de cliente (PERSONA_NATURAL/EMPRESARIO).")
   String tipo,

   @NotBlank(message = "El cliente debe tener un documento de identificación único.")
   String numeroDocumento,

   @NotBlank(message = "El cliente debe tener un email de contacto.")
   String emailContacto,

   @NotBlank(message = "El cliente debe tener un teléfono de contacto.")
   String telefonoContacto,

   @NotBlank(message = "El cliente debe tener una dirección única.")
   String direccionPrincipal
) {}
