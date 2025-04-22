package com.sistemas_mangager_be.edu_virtual_ufps.repositories;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
    List<Documento> findByProyectoId(Integer idProyecto);
}