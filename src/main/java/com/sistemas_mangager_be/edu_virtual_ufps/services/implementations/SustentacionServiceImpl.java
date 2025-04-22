package com.sistemas_mangager_be.edu_virtual_ufps.services.implementations;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Sustentacion;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.Usuario;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.intermedias.SustentacionEvaluador;
import com.sistemas_mangager_be.edu_virtual_ufps.mappers.SustentacionMapper;
import com.sistemas_mangager_be.edu_virtual_ufps.repositories.*;
import com.sistemas_mangager_be.edu_virtual_ufps.services.interfaces.SustentacionService;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.SustentacionDto;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.SustentacionEvaluadorDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SustentacionServiceImpl implements SustentacionService {
    private final SustentacionRepository sustentacionRepository;
    private final SustentacionMapper sustentacionMapper;
    private final SustentacionDocumentoRepository sustentacionDocumentoRepository;
    private final SustentacionEvaluadorRepository sustentacionEvaluadorRepository;
    private final ProyectoRepository proyectoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public SustentacionDto crearSustentacion(SustentacionDto sustentacionDto) {
        if (!proyectoRepository.existsById(sustentacionDto.getIdProyecto())) {
            throw new EntityNotFoundException("Proyecto no encontrado");
        }

        Sustentacion sustentacion = sustentacionMapper.toEntity(sustentacionDto);

        Sustentacion savedSustentacion = sustentacionRepository.save(sustentacion);

        return sustentacionMapper.toDto(savedSustentacion);
    }

    @Override
    @Transactional(readOnly = true)
    public SustentacionDto obtenerSustentacion(Integer id) {
        Sustentacion sustentacion = sustentacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sustentacion no encontrada"));

        SustentacionDto sustentacionDto = sustentacionMapper.toDto(sustentacion);
        List<SustentacionEvaluador> evaluadores = sustentacionEvaluadorRepository.findByIdSustentacion(id);

        List<SustentacionEvaluadorDto> evaluadoresDto = evaluadores.stream()
                .map(evaluador -> new SustentacionEvaluadorDto(
                        evaluador.getIdSustentacion(),
                        evaluador.getIdUsuario(),
                        evaluador.getObservaciones(),
                        evaluador.getNota()))
                .collect(Collectors.toList());

        sustentacionDto.setEvaluadores(evaluadoresDto);
        return sustentacionDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SustentacionDto> listarSustentaciones() {
        return sustentacionRepository.findAll().stream()
                .map(sustentacionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SustentacionDto actualizarSustentacion(Integer id, SustentacionDto sustentacionDto) {
        Sustentacion sustentacion = sustentacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sustentacion no encontrada"));

        if (!proyectoRepository.existsById(sustentacion.getProyecto().getId())) {
            throw new EntityNotFoundException("Proyecto no encontrado");
        }

        sustentacionMapper.partialUpdate(sustentacionDto, sustentacion);
        Sustentacion updatedSustentacion = sustentacionRepository.save(sustentacion);

        return sustentacionMapper.toDto(updatedSustentacion);
    }

    @Override
    @Transactional
    public void eliminarSustentacion(Integer id) {
        if (!sustentacionRepository.existsById(id)) {
            throw new EntityNotFoundException("Sustentacion no encontrada");
        }
        sustentacionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void asignarEvaluadorASustentacion(SustentacionEvaluadorDto sustentacionEvaluadorDto) {
        Sustentacion sustentacion = sustentacionRepository.findById(sustentacionEvaluadorDto.getIdSustentacion())
                .orElseThrow(() -> new EntityNotFoundException("Sustentacion no encontrada"));

        Usuario usuario = usuarioRepository.findById(sustentacionEvaluadorDto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario con ID " + sustentacionEvaluadorDto.getIdUsuario() + " no encontrado"));

        SustentacionEvaluador sustentacionEvaluador = new SustentacionEvaluador();
        sustentacionEvaluador.setIdSustentacion(sustentacion.getId());
        sustentacionEvaluador.setIdUsuario(usuario.getId());
        sustentacionEvaluador.setSustentacion(sustentacion);
        sustentacionEvaluador.setUsuario(usuario);

        sustentacionEvaluadorRepository.save(sustentacionEvaluador);
    }

    @Override
    @Transactional
    public void eliminarEvaluadorDeSustentacion(Integer idSustentacion, Integer idEvaluador) {
        boolean existe = sustentacionEvaluadorRepository.existsByIdUsuarioAndIdSustentacion(idEvaluador, idSustentacion);

        if (!existe) {
            throw new RuntimeException("La asignación no existe");
        }

        sustentacionEvaluadorRepository.deleteByIdUsuarioAndIdSustentacion(idEvaluador, idSustentacion);
    }

    @Override
    @Transactional
    public void evaluarSustentacion(SustentacionEvaluadorDto sustentacionEvaluadorDto) {
        boolean existe = sustentacionEvaluadorRepository.existsByIdUsuarioAndIdSustentacion(
                sustentacionEvaluadorDto.getIdUsuario(),
                sustentacionEvaluadorDto.getIdSustentacion());

        if (!existe) {
            throw new RuntimeException("La asignación no existe");
        }

        SustentacionEvaluador sustentacionEvaluador = sustentacionEvaluadorRepository.findByIdUsuarioAndIdSustentacion(
                sustentacionEvaluadorDto.getIdUsuario(),
                sustentacionEvaluadorDto.getIdSustentacion());

        if (sustentacionEvaluadorDto.getObservaciones() != null && !sustentacionEvaluadorDto.getObservaciones().isBlank()) {
            sustentacionEvaluador.setObservaciones(sustentacionEvaluadorDto.getObservaciones());
        }
        if (sustentacionEvaluadorDto.getNota() != null) {
            sustentacionEvaluador.setNota(sustentacionEvaluadorDto.getNota());
        }
        sustentacionEvaluadorRepository.save(sustentacionEvaluador);
    }
}
