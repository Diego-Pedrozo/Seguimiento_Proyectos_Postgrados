package com.sistemas_mangager_be.edu_virtual_ufps.entities.intermedias;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Proyecto;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.Rol;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.Usuario;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.id_compuesto.UsuarioProyectoId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UsuarioProyectoId.class)
public class UsuarioProyecto {
    @Id
    private Integer idUsuario;

    @Id
    private Integer idProyecto;


    @ManyToOne
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idProyecto", insertable = false, updatable = false)
    private Proyecto proyecto;

    @ManyToOne
    private Rol rol;
}

