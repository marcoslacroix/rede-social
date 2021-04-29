package com.example.redesocial.controller;

import com.example.redesocial.dto.UserDto;

import com.example.redesocial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/add")
    public ResponseEntity<?> add(UserDto userDto) {
        return (ResponseEntity<?>) ResponseEntity.ok();
    }
}
