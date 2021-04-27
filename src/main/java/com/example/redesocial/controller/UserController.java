package com.example.redesocial.controller;

import com.example.redesocial.dto.UserDto;

import com.example.redesocial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/add")
    public ResponseEntity<UserDto> add() {
        return ResponseEntity.ok(userService.add());
    }
}
