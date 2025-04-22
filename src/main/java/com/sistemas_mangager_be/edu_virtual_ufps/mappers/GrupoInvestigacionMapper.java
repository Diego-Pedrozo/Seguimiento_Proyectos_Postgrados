package com.sistemas_mangager_be.edu_virtual_ufps.mappers;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.GrupoInvestigacion;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.GrupoInvestigacionDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GrupoInvestigacionMapper {
    GrupoInvestigacion toEntity(GrupoInvestigacionDto grupoInvestigacionDto);

    GrupoInvestigacionDto toDto(GrupoInvestigacion grupoInvestigacion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    GrupoInvestigacion partialUpdate(GrupoInvestigacionDto grupoInvestigacionDto, @MappingTarget GrupoInvestigacion grupoInvestigacion);
}