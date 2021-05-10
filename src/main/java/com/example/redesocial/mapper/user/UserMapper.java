package com.example.redesocial.mapper.user;

import com.example.redesocial.dto.user.UserDto;
import com.example.redesocial.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);
}
