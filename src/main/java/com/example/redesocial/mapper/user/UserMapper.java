package com.example.redesocial.mapper.user;

import com.example.redesocial.dto.user.UserDto;
import com.example.redesocial.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
}
