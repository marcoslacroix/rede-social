package com.example.redesocial.controller;

import com.example.redesocial.dto.user.UserCreateDto;
import com.example.redesocial.dto.user.UserDto;
import com.example.redesocial.entity.User;
import com.example.redesocial.repository.UserRepository;
import com.example.redesocial.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static java.util.Objects.nonNull;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping
    @ApiOperation(value = "Cria um usuário", response = UserDto.class)
    public ResponseEntity<?> create(@RequestBody UserCreateDto userCreateDto) {
        User user = userRepository.findByEmail(userCreateDto.getEmail());
        if (nonNull(user)) {
            return new ResponseEntity<>("User with " + user.getEmail() + " is already exist", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.create(userCreateDto));
    }
}
