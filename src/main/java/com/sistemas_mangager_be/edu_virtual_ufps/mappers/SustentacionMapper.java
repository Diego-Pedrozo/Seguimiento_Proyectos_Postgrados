package com.sistemas_mangager_be.edu_virtual_ufps.mappers;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Sustentacion;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.SustentacionDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SustentacionMapper {
    @Mapping(source = "idProyecto", target = "proyecto.id")
    Sustentacion toEntity(SustentacionDto sustentacionDto);

    @Mapping(source = "proyecto.id", target = "idProyecto")
    SustentacionDto toDto(Sustentacion sustentacion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Sustentacion partialUpdate(SustentacionDto sustentacionDto, @MappingTarget Sustentacion sustentacion);
}