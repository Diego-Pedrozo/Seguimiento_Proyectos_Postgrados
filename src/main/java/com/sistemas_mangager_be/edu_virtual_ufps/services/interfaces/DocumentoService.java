package com.sistemas_mangager_be.edu_virtual_ufps.services.interfaces;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.enums.TipoDocumento;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.DocumentoDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentoService {
    DocumentoDto guardarDocumento(Integer idProyecto, MultipartFile archivo, TipoDocumento tipoDocumento);
    List<DocumentoDto> listarPorProyecto(Integer idProyecto);

    void eliminarDocumento(Integer id);
}
