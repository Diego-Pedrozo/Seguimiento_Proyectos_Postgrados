package com.sistemas_mangager_be.edu_virtual_ufps.controllers;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.enums.TipoDocumento;
import com.sistemas_mangager_be.edu_virtual_ufps.services.interfaces.DocumentoService;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.DocumentoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService documentoService;

    @PostMapping("/{idProyecto}")
    public ResponseEntity<DocumentoDto> subirDocumento(
            @PathVariable Integer idProyecto,
            @RequestParam("archivo") MultipartFile archivo,
            @RequestParam("tipoDocumento") TipoDocumento tipoDocumento
    ) {
        return ResponseEntity.ok(documentoService.guardarDocumento(idProyecto, archivo, tipoDocumento));
    }

    @GetMapping("/proyecto/{idProyecto}")
    public ResponseEntity<List<DocumentoDto>> listarPorProyecto(@PathVariable Integer idProyecto) {
        return ResponseEntity.ok(documentoService.listarPorProyecto(idProyecto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDocumento(@PathVariable Integer id) {
        documentoService.eliminarDocumento(id);
        return ResponseEntity.noContent().build();
    }
}
