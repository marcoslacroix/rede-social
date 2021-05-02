package com.example.redesocial.service;

import com.example.redesocial.config.PasswordEncoder;
import com.example.redesocial.dto.user.create.UserCreateDto;
import com.example.redesocial.dto.user.UserDto;
import com.example.redesocial.entity.User;
import com.example.redesocial.mapper.user.UserCreateMapper;
import com.example.redesocial.mapper.user.UserMapper;
import com.example.redesocial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public UserDto create(UserCreateDto userCreateDto) {
        User user = userRepository.findByEmailPrincipal(userCreateDto.getEmailPrincipal());
        if (nonNull(user)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Email %s already registered ", user.getEmailPrincipal()));
        }
        user = UserCreateMapper.INSTANCE.toUser(userCreateDto);
        user.setPassword(PasswordEncoder.passwordEncoder().encode(userCreateDto.getPassword()));
        return UserMapper.INSTANCE.toDto(userRepository.save(user));
    }

    @Transactional(rollbackFor = Exception.class)
    public void inactive(String uuid) {
        User user = findByUuid(uuid);
        user.setActivated(false);
        user.setUpdatedOn(LocalDateTime.now());
        userRepository.save(user);
    }

    private User findByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid);
        if (isNull(user)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("UUID %s not found ", uuid));
        }
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    public void changePassword(String newPassword, String newPassword2, String oldPassword, String uuid) {
        User user = findByUuid(uuid);
        if (newPassword.equals(newPassword2)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "The new password do not match");
        } else if (PasswordEncoder.passwordEncoder().matches(oldPassword, user.getPassword())) {
            user.setPassword(PasswordEncoder.passwordEncoder().encode(newPassword));
            user.setUpdatedOn(LocalDateTime.now());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "The current password is incorrect.");
        }
        userRepository.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void changeEmailPrincipal(String newEmail, String uuid) {
        User user = findByUuid(uuid);
        User searchNewEmail = userRepository.findByEmailPrincipal(newEmail);
        if (nonNull(searchNewEmail)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Email %s already registered ", searchNewEmail.getEmailPrincipal()));
        }
        user.setEmailPrincipal(newEmail);
        user.setUpdatedOn(LocalDateTime.now());
        userRepository.save(user);
    }
}
