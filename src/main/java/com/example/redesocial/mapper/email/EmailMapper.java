package com.example.redesocial.mapper.email;

import com.example.redesocial.dto.email.EmailDto;
import com.example.redesocial.entity.Email;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmailMapper {

    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    EmailDto toDto(Email email);}
