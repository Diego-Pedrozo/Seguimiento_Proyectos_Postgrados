package com.sistemas_mangager_be.edu_virtual_ufps.entities;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.enums.TipoDocumento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipoArchivo;
    private String nombre;
    private String path;
    private String peso;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;
}

