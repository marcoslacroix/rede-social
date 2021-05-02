package com.example.redesocial.mapper.user;

import com.example.redesocial.dto.user.update.UserUpdateDto;
import com.example.redesocial.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserUpdateMapper {
    UserUpdateMapper INSTANCE = Mappers.getMapper(UserUpdateMapper.class);

    User toUser(UserUpdateDto userUpdateDto);
}
