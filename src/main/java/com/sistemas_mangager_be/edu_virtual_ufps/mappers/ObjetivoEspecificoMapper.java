package com.sistemas_mangager_be.edu_virtual_ufps.mappers;

import com.sistemas_mangager_be.edu_virtual_ufps.entities.ObjetivoEspecifico;
import com.sistemas_mangager_be.edu_virtual_ufps.shared.DTOs.ObjetivoEspecificoDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ObjetivoEspecificoMapper {
    ObjetivoEspecifico toEntity(ObjetivoEspecificoDto objetivoEspecificoDto);

    ObjetivoEspecificoDto toDto(ObjetivoEspecifico objetivoEspecifico);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(ObjetivoEspecificoDto objetivoEspecificoDto, @MappingTarget ObjetivoEspecifico objetivoEspecifico);
}