package com.sistemas_mangager_be.edu_virtual_ufps.services.interfaces;

import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.ProyectoDto;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.UsuarioProyectoDto;

import java.util.List;

public interface ProyectoService {

    ProyectoDto crearProyecto(ProyectoDto proyectoDto);

    ProyectoDto obtenerProyecto(Integer id);

    List<ProyectoDto> listarProyectos();

    ProyectoDto actualizarProyecto(Integer id, ProyectoDto dto);

    void eliminarProyecto(Integer id);

    void asignarUsuarioAProyecto(UsuarioProyectoDto usuarioProyectoDto);

    void desasignarUsuarioDeProyecto(Integer idUsuario, Integer idProyecto);
}
