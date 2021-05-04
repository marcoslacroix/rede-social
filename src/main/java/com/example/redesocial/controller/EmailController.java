package com.example.redesocial.controller;

import com.example.redesocial.dto.email.EmailDto;
import com.example.redesocial.dto.email.create.EmailCreateDto;
import com.example.redesocial.dto.user.create.UserCreateDto;
import com.example.redesocial.service.EmailService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    @ApiOperation(value = "Create another email for user", response = EmailDto.class)
    public ResponseEntity<EmailDto> create(@RequestBody EmailCreateDto emailCreateDto) {
        return ResponseEntity.ok(emailService.create(emailCreateDto));
    }
}
