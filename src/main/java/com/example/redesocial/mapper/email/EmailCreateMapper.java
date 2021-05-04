package com.example.redesocial.mapper.email;

import com.example.redesocial.dto.email.create.EmailCreateDto;
import com.example.redesocial.entity.Email;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring",
        imports = {UUID.class})
public interface EmailCreateMapper {

    EmailCreateMapper INSTANCE = Mappers.getMapper(EmailCreateMapper.class);

    @Mapping(target = "userId", source = "email.user.id")
    EmailCreateDto toDto(Email email);

    @Mappings({
            @Mapping(target = "uuid", expression = "java(UUID.randomUUID().toString())"),
            @Mapping(target = "userId", source = "emailCreateDto.userId")
    })
    Email toEmail(EmailCreateDto emailCreateDto);
}
