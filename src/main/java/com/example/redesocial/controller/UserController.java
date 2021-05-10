package com.example.redesocial.controller;

import com.example.redesocial.dto.email.EmailDto;
import com.example.redesocial.dto.user.UserDto;
import com.example.redesocial.dto.user.create.UserCreateDto;
import com.example.redesocial.dto.work.WorkDto;
import com.example.redesocial.dto.work.create.WorkCreateDto;
import com.example.redesocial.dto.work.update.WorkUpdateDto;
import com.example.redesocial.service.EmailService;
import com.example.redesocial.service.UserService;
import com.example.redesocial.service.WorkService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final EmailService emailService;
    private final WorkService workService;

    @PostMapping
    @ApiOperation(value = "Create user", response = UserDto.class)
    public ResponseEntity<UserDto> create(@RequestBody @Valid UserCreateDto userCreateDto) {
        return ResponseEntity.ok(userService.create(userCreateDto));
    }

    @PutMapping("/inactive")
    @ApiOperation(value = "Inactivate user")
    public ResponseEntity<Void> inactive(@RequestParam @NotBlank Long id) {
        userService.inactive(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updatePassword")
    @ApiOperation(value = "Change password")
    public ResponseEntity<Void> changePassword(@RequestParam @NotBlank String newPassword,
                                               @RequestParam @NotBlank String newPassword2,
                                               @RequestParam @NotBlank String oldPassword,
                                               @RequestParam @NotBlank Long id) {
        userService.changePassword(newPassword, newPassword2, oldPassword, id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateEmail/{userId}")
    @ApiOperation(value = "Update email")
    public ResponseEntity<Void> changeEmail(@PathVariable @NotBlank String newEmail,
                                            @PathVariable @NotBlank Long userId) {
        userService.changeEmailPrincipal(newEmail, userId);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/email/{userId}")
    @ApiOperation(value = "Create another email for user", response = EmailDto.class)
    public ResponseEntity<EmailDto> create(@PathVariable Long userId, @RequestParam String email) {
        return ResponseEntity.ok(emailService.create(userId, email));
    }

    @DeleteMapping("/email/{emailId}")
    @ApiOperation(value = "Delete a email")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long emailId) {
        emailService.delete(emailId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/work")
    @ApiOperation(value = "Create work", response = WorkDto.class)
    public ResponseEntity<WorkDto> createWork(@RequestBody @Valid WorkCreateDto workCreateDto) {
        return ResponseEntity.ok(workService.create(workCreateDto));
    }

    @PutMapping("/work/update")
    @ApiOperation(value = "Update work", response = WorkDto.class)
    public ResponseEntity<WorkDto> updateWork(@RequestBody @Valid WorkUpdateDto workUpdateDto) {
        return ResponseEntity.ok(workService.update(workUpdateDto));
    }

    @DeleteMapping("/work/{workId}")
    @ApiOperation(value = "Deletar work")
    public ResponseEntity<Void> deleteWork(@PathVariable Long workId) {
        workService.delete(workId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/photo/{userId}")
    @ApiOperation(value = "Upload photo")
    public ResponseEntity<?> upload(@PathVariable Long userId,
                                    @RequestParam(value = "file") MultipartFile multipartFile) throws IOException {
        userService.uploadPhoto(userId, multipartFile);
        return ResponseEntity.ok().build();
    }

    @GetMapping(
            value = "/image/{userId}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    @ApiOperation(value = "Show photo")
    public ResponseEntity<byte[]> getPhoto(@PathVariable Long userId) throws IOException {
        return ResponseEntity.ok(userService.getPhoto(userId));
    }

}
