package com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Rol;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.intermedias.UsuarioProyecto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link UsuarioProyecto}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioProyectoDto implements Serializable {
    Integer idUsuario;
    Integer idProyecto;
    Rol rol;

    private String nombreUsuario;
    private String fotoUsuario;
    private String email;
    private String telefono;
}