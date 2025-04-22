package com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Proyecto;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.DefinitivaDto;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.LineaInvestigacionDto;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.ObjetivoEspecificoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Proyecto}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyectoDto implements Serializable {
    Integer id;
    String titulo;
    String pregunta;
    String problema;
    String objetivoGeneral;
    Integer estadoActual;
    List<ObjetivoEspecificoDto> objetivosEspecificos;
    LineaInvestigacionDto lineaInvestigacion;
    List<UsuarioProyectoDto> usuariosAsignados;
}