package com.example.redesocial.mapper.work;

import com.example.redesocial.dto.work.WorkDto;
import com.example.redesocial.model.Work;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WorkMapper {

    WorkMapper INSTANCE = Mappers.getMapper(WorkMapper.class);

    WorkDto toDto(Work work);
}
