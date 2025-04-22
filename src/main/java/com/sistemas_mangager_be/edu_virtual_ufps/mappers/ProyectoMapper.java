package com.sistemas_mangager_be.edu_virtual_ufps.mappers;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Proyecto;
import com.sistemas_mangager_be.edu_virtual_ufps.entities.enums.EstadoProyecto;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.ProyectoDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ObjetivoEspecificoMapper.class, LineaInvestigacionMapper.class})
public interface ProyectoMapper {

    @Mapping(target = "estadoActual", source = "estadoActual", qualifiedByName = "intToEstadoProyecto")
    Proyecto toEntity(ProyectoDto proyectoDto);

    @AfterMapping
    default void linkObjetivosEspecificos(@MappingTarget Proyecto proyecto) {
        proyecto.getObjetivosEspecificos().forEach(objetivosEspecifico -> objetivosEspecifico.setProyecto(proyecto));
    }

    @Mapping(target = "estadoActual", source = "estadoActual", qualifiedByName = "estadoProyectoToInt")
    ProyectoDto toDto(Proyecto proyecto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "estadoActual", source = "estadoActual", qualifiedByName = "intToEstadoProyecto")
    void partialUpdate(ProyectoDto proyectoDto, @MappingTarget Proyecto proyecto);

    @Named("estadoProyectoToInt")
    static int estadoProyectoToInt(EstadoProyecto estado) {
        return estado != null ? estado.ordinal() : -1;
    }

    @Named("estadoProyectoToDescripcion")
    static String estadoProyectoToDescripcion(EstadoProyecto estado) {
        return estado != null ? estado.getDescripcion() : null;
    }

    @Named("intToEstadoProyecto")
    static EstadoProyecto intToEstadoProyecto(int code) {
        return EstadoProyecto.fromCode(code);
    }
}