package com.sistemas_mangager_be.edu_virtual_ufps.mappers;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.LineaInvestigacion;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.LineaInvestigacionDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LineaInvestigacionMapper {
    LineaInvestigacion toEntity(LineaInvestigacionDto lineaInvestigacionDto);

    LineaInvestigacionDto toDto(LineaInvestigacion lineaInvestigacion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LineaInvestigacion partialUpdate(LineaInvestigacionDto lineaInvestigacionDto, @MappingTarget LineaInvestigacion lineaInvestigacion);
}