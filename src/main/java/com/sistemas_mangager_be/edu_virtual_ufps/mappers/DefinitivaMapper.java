package com.sistemas_mangager_be.edu_virtual_ufps.mappers;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.Definitiva;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.DefinitivaDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DefinitivaMapper {
    Definitiva toEntity(DefinitivaDto definitivaDto);

    DefinitivaDto toDto(Definitiva definitiva);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Definitiva partialUpdate(DefinitivaDto definitivaDto, @MappingTarget Definitiva definitiva);
}