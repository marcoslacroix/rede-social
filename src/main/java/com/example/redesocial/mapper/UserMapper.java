package com.example.redesocial.mapper;

import com.example.redesocial.dto.UserDto;
import com.example.redesocial.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User toUser(UserDto userDto);

    UserDto toUser(User user);
}
