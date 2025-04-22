package com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.intermedias.SustentacionEvaluador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link SustentacionEvaluador}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SustentacionEvaluadorDto implements Serializable {
    private Integer idSustentacion;
    private Integer idUsuario;
    private String observaciones;
    private Double nota;
}