package com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Definitiva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Definitiva}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefinitivaDto implements Serializable {
    Integer id;
    Double calificacion;
    Boolean honores;
}