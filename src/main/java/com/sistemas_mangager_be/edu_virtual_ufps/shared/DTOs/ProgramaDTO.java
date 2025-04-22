package com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramaDTO {
    
    private Integer id;
    
    private String nombre;

    private String codigo;

    private Boolean esPosgrado;


}
