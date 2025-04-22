package com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.ObjetivoEspecifico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link ObjetivoEspecifico}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjetivoEspecificoDto implements Serializable {
    Integer id;
    Integer numeroOrden;
    String descripcion;
    Integer avanceReportado;
    Integer avanceReal;
    Boolean evaluacion;
    LocalDate fecha_inicio;
    LocalDate fecha_fin;
}