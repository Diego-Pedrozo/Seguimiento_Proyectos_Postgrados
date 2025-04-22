package com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.sistemas_mangager_be.edu_virtual_ufps.entities.LineaInvestigacion}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaInvestigacionDto implements Serializable {
    Integer id;
    String nombre;
    GrupoInvestigacionDto grupoInvestigacion;
}