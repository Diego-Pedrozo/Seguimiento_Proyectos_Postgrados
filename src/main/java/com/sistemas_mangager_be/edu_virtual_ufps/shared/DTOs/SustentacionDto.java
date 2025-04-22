package com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Sustentacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * DTO for {@link Sustentacion}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SustentacionDto implements Serializable {
    Integer id;
    LocalDate fecha;
    LocalTime hora;
    String descripcion;
    Integer idProyecto ;
    List<SustentacionEvaluadorDto> evaluadores;
}