package com.example.redesocial.service;

import com.example.redesocial.dto.user.UserCreateDto;
import com.example.redesocial.dto.user.UserDto;
import com.example.redesocial.entity.User;
import com.example.redesocial.mapper.user.UserCreateMapper;
import com.example.redesocial.mapper.user.UserMapper;
import com.example.redesocial.repository.ContactRepository;
import com.example.redesocial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ContactRepository contactRepository;
    private final UserCreateMapper userCreateMapper;
    private final UserMapper userMapper;

    @Transactional
    public UserDto create(UserCreateDto userCreateDto) {

        User user = userCreateMapper.toUser(userCreateDto);
        userRepository.save(user);

        return userMapper.toDto(user);

    }
}
