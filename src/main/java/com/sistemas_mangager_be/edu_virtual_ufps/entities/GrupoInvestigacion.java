package com.sistemas_mangager_be.edu_virtual_ufps.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grupo_investigacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoInvestigacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_programa", referencedColumnName = "id")
    private Programa programa;
}
