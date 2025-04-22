package com.sistemas_mangager_be.edu_virtual_ufps.entities.intermedias;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Documento;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.Sustentacion;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.id_compuesto.SustentacionDocumentoId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SustentacionDocumentoId.class)
public class SustentacionDocumento {
    @Id
    private Integer idSustentacion;

    @Id
    private Integer idDocumento;

    @ManyToOne
    @JoinColumn(name = "idSustentacion", insertable = false, updatable = false)
    private Sustentacion sustentacion;

    @ManyToOne
    @JoinColumn(name = "idDocumento", insertable = false, updatable = false)
    private Documento documento;
}

