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

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserCreateMapper userCreateMapper;
    private final UserMapper userMapper;

    @Transactional
    public ResponseEntity<?> create(UserCreateDto userCreateDto) {

        User user2 = userRepository.findByEmail(userCreateDto.getEmail());
        if (nonNull(user2)) {
            return ResponseEntity.badRequest().body("Usuário já cadastrado");
        }

        User user = userCreateMapper.toUser(userCreateDto);
        user.setPassword(PasswordEncoder.passwordEncoder().encode(userCreateDto.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
