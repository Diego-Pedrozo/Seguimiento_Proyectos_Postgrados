package com.sistemas_mangager_be.edu_virtual_ufps.entities.intermedias;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.id_compuesto.ColoquioEstudianteId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(ColoquioEstudianteId.class)
public class ColoquioEstudiante {

    @Id
    private Integer idColoquio;

    @Id
    private Integer idEstudiante;

    @Id
    private Integer idDocumento;
}

