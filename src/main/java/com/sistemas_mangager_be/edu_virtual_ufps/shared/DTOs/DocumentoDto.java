package com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.enums.TipoDocumento;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.sistemas_mangager_be.edu_virtual_ufps.entities.Documento}
 */
@Value
public class DocumentoDto implements Serializable {
    Integer id;
    String tipoArchivo;
    String nombre;
    String path;
    String peso;
    TipoDocumento tipoDocumento;
    Integer idProyecto;
}