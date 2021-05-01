package com.example.redesocial.service;

import com.example.redesocial.config.PasswordEncoder;
import com.example.redesocial.dto.user.UserCreateDto;
import com.example.redesocial.dto.user.UserDto;
import com.example.redesocial.entity.User;
import com.example.redesocial.mapper.user.UserCreateMapper;
import com.example.redesocial.mapper.user.UserMapper;
import com.example.redesocial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserCreateMapper userCreateMapper;
    private final UserMapper userMapper;

    public UserDto create(UserCreateDto userCreateDto) {

        User user = userRepository.findByEmail(userCreateDto.getEmail());
        if (nonNull(user)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado " + user.getEmail());
        }

        user = userCreateMapper.toUser(userCreateDto);
        user.setPassword(PasswordEncoder.passwordEncoder().encode(userCreateDto.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}
