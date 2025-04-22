package com.sistemas_mangager_be.edu_virtual_ufps.entities.intermedias;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Sustentacion;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.Usuario;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.id_compuesto.SustentacionEvaluadorId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SustentacionEvaluadorId.class)
public class SustentacionEvaluador {
    @Id
    private Integer idSustentacion;

    @Id
    private Integer idUsuario;

    private String observaciones;
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "idSustentacion", insertable = false, updatable = false)
    private Sustentacion sustentacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;
}
