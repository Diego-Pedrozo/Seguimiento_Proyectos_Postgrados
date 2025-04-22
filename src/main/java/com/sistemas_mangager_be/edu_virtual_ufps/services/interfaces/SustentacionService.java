package com.sistemas_mangager_be.edu_virtual_ufps.services.interfaces;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.intermedias.SustentacionEvaluador;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.SustentacionDto;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.SustentacionEvaluadorDto;

import java.util.List;

public interface SustentacionService {

    SustentacionDto crearSustentacion(SustentacionDto sustentacionDto);

    SustentacionDto obtenerSustentacion(Integer id);

    List<SustentacionDto> listarSustentaciones();

    SustentacionDto actualizarSustentacion(Integer id, SustentacionDto sustentacionDto);

    void eliminarSustentacion(Integer id);

    void asignarEvaluadorASustentacion(SustentacionEvaluadorDto sustentacionEvaluadorDto);

    void eliminarEvaluadorDeSustentacion(Integer idSustentacion, Integer idEvaluador);

    void evaluarSustentacion(SustentacionEvaluadorDto sustentacionEvaluadorDto);
}
