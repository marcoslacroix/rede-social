package com.example.redesocial.service;

import com.example.redesocial.config.PasswordEncoder;
import com.example.redesocial.dto.user.UserDto;
import com.example.redesocial.dto.user.create.UserCreateDto;
import com.example.redesocial.model.Photo;
import com.example.redesocial.model.User;
import com.example.redesocial.exception.EmailAlreadyFound;
import com.example.redesocial.mapper.user.UserCreateMapper;
import com.example.redesocial.mapper.user.UserMapper;
import com.example.redesocial.repository.PhotoRepository;
import com.example.redesocial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PhotoRepository photoRepository;

    @Transactional(rollbackFor = Exception.class)
    public UserDto create(UserCreateDto userCreateDto) {
        User user = userRepository.findByEmailPrincipal(userCreateDto.getEmailPrincipal());
        if (nonNull(user)) {
            throw new EmailAlreadyFound(user.getEmailPrincipal());
        }
        user = UserCreateMapper.INSTANCE.toUser(userCreateDto);
        user.setPassword(PasswordEncoder.passwordEncoder().encode(userCreateDto.getPassword()));
        return UserMapper.INSTANCE.toDto(userRepository.save(user));
    }

    @Transactional(rollbackFor = Exception.class)
    public void inactive(Long id) {
        User user = findById(id);
        user.setActivated(false);
        user.setUpdatedOn(LocalDateTime.now());
        userRepository.save(user);
    }

    private User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (isNull(user)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("UUID %s not found ", id));
        }
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    public void changePassword(String newPassword, String newPassword2, String oldPassword, Long id) {
        User user = findById(id);
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
    public void changeEmailPrincipal(String newEmail, Long id) {
        User user = findById(id);
        User searchNewEmail = userRepository.findByEmailPrincipal(newEmail);
        if (nonNull(searchNewEmail)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Email %s already registered ", searchNewEmail.getEmailPrincipal()));
        }
        user.setEmailPrincipal(newEmail);
        user.setUpdatedOn(LocalDateTime.now());
        userRepository.save(user);
    }

    @Transactional
    public void uploadPhoto(Long userId, MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            Photo photo = new Photo();
            photo.setUuid(UUID.randomUUID().toString());
            photo.setImage(multipartFile.getBytes());
            photo.setUserId(userId);
            photoRepository.save(photo);
        }
    }

    public byte[] getPhoto(Long photoId) {
        Photo photo = photoRepository.findById(photoId).orElse(null);
        if (isNull(photo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Photo not found.");
        }
        return photo.getImage();
    }
}
