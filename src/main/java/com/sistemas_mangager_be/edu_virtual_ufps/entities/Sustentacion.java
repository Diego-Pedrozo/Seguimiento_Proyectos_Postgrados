package com.sistemas_mangager_be.edu_virtual_ufps.entities;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.intermedias.SustentacionDocumento;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.intermedias.SustentacionEvaluador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sustentacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate fecha;
    private LocalTime hora;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    @OneToMany(mappedBy = "sustentacion", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<SustentacionEvaluador> evaluadores;

    @OneToMany(mappedBy = "sustentacion", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<SustentacionDocumento> documentos;
}

