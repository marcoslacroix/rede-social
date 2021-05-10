package com.example.redesocial.mapper.work;

import com.example.redesocial.dto.work.create.WorkCreateDto;
import com.example.redesocial.model.Work;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring",
        imports = {UUID.class})
public interface WorkCreateMapper {

    WorkCreateMapper INSTANCE = Mappers.getMapper(WorkCreateMapper.class);

    @Mappings({
            @Mapping(target = "uuid", expression = "java(UUID.randomUUID().toString())")
    })
    Work toWork(WorkCreateDto workCreateDto);

}
