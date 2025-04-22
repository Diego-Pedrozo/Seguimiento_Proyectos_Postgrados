package com.sistemas_mangager_be.edu_virtual_ufps.services.implementations;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Documento;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.Proyecto;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.enums.TipoDocumento;
import com.sistemas_mangager_be.edu_virtual_ufps.mappers.DocumentoMapper;
import com.sistemas_mangager_be.edu_virtual_ufps.repositories.DocumentoRepository;
import com.sistemas_mangager_be.edu_virtual_ufps.repositories.ProyectoRepository;
import com.sistemas_mangager_be.edu_virtual_ufps.services.interfaces.DocumentoService;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.DocumentoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentoServiceImpl implements DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final ProyectoRepository proyectoRepository;
    private final DocumentoMapper documentoMapper;

    private final String uploadDir = "uploads/documentos";

    @Override
    @Transactional
    public DocumentoDto guardarDocumento(Integer idProyecto, MultipartFile archivo, TipoDocumento tipoDocumento) {
        Proyecto proyecto = proyectoRepository.findById(idProyecto)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        try {
            Files.createDirectories(Paths.get(uploadDir));
            String fileName = UUID.randomUUID() + "_" + archivo.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);

            Files.copy(archivo.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            Documento documento = new Documento();
            documento.setNombre(archivo.getOriginalFilename());
            documento.setPath(filePath.toString());
            documento.setTipoArchivo(archivo.getContentType());
            documento.setPeso(archivo.getSize() / 1024 + " KB");
            documento.setTipoDocumento(tipoDocumento);
            documento.setProyecto(proyecto);

            return documentoMapper.toDto(documentoRepository.save(documento));

        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentoDto> listarPorProyecto(Integer idProyecto) {
        return documentoRepository.findByProyectoId(idProyecto)
                .stream()
                .map(documentoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void eliminarDocumento(Integer id) {
        Documento documento = documentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));

        try {
            Files.deleteIfExists(Paths.get(documento.getPath()));
        } catch (IOException e) {
            throw new RuntimeException("Error al eliminar archivo físico", e);
        }

        documentoRepository.deleteById(id);
    }
}
