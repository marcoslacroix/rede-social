package com.example.redesocial.controller;

import com.example.redesocial.dto.user.UserCreateDto;
import com.example.redesocial.dto.user.UserDto;
import com.example.redesocial.repository.UserRepository;
import com.example.redesocial.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ApiOperation(value = "Cria um usuário", response = UserDto.class)
    public ResponseEntity<?> create(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.ok(userService.create(userCreateDto));
    }
}
