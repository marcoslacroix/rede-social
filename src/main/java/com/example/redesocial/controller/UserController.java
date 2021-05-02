package com.example.redesocial.controller;

import com.example.redesocial.dto.user.create.UserCreateDto;
import com.example.redesocial.dto.user.UserDto;
import com.example.redesocial.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ApiOperation(value = "Create user", response = UserDto.class)
    public ResponseEntity<UserDto> create(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.ok(userService.create(userCreateDto));
    }

    @PostMapping("/inactive")
    @ApiOperation(value = "Inactivate user")
    public ResponseEntity<?> inactive(@RequestParam @NotBlank String uuid) {
        userService.inactive(uuid);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/updatePassword")
    @ApiOperation(value = "Change password")
    public ResponseEntity<?> changePassword(@RequestParam @NotBlank String newPassword,
                                 @RequestParam @NotBlank String newPassword2,
                                 @RequestParam @NotBlank String oldPassword,
                                 @RequestParam @NotBlank String uuid) {
        userService.changePassword(newPassword, newPassword2, oldPassword, uuid);
        return ResponseEntity.ok("Password Updated sucessfully");
    }

    @PostMapping("/updateEmail")
    @ApiOperation(value = "Change email")
    public ResponseEntity<?> changeEmail(@RequestParam @NotBlank String newEmail,
                                         @RequestParam @NotBlank String uuid) {
        userService.changeEmailPrincipal(newEmail, uuid);
        return ResponseEntity.ok("Email changed sucessfully");
    }
}
