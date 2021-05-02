package com.example.redesocial.mapper.user;

import com.example.redesocial.dto.user.UserCreateDto;
import com.example.redesocial.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper(componentModel = "spring",
        imports = {UUID.class, LocalDateTime.class})
public interface UserCreateMapper {

    UserCreateMapper INSTANCE = Mappers.getMapper(UserCreateMapper.class);

    UserCreateDto toDto(User user);

    @Mappings({
            @Mapping(target = "uuid", expression = "java(UUID.randomUUID().toString())"),
            @Mapping(target = "createdOn", expression = "java(LocalDateTime.now())")

    })
    User toUser(UserCreateDto userCreateDto);
}
