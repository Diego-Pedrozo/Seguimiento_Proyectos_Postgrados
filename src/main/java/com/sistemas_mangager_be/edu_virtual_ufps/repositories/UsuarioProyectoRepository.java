package com.sistemas_mangager_be.edu_virtual_ufps.repositories;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.id_compuesto.UsuarioProyectoId;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.intermedias.UsuarioProyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioProyectoRepository extends JpaRepository<UsuarioProyecto, UsuarioProyectoId> {

    void deleteByIdUsuarioAndIdProyecto(Integer idUsuario, Integer idProyecto);

    boolean existsByIdUsuarioAndIdProyecto(Integer idUsuario, Integer idProyecto);

    List<UsuarioProyecto> findByIdProyecto(Integer idProyecto);
}