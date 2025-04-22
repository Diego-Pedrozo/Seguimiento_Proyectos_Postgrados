package com.sistemas_mangager_be.edu_virtual_ufps.repositories;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
}