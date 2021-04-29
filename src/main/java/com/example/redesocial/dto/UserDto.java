package com.example.redesocial.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Value
@Getter
@RequiredArgsConstructor
@Jacksonized
public class UserDto {

    Long id;

    String name;

    String lastName;

    String email;

    String password;

    String uuid;

    LocalDate birthdate;

    LocalDateTime createdOn;

    LocalDateTime updatedOn;

    List<ContactDto> contacts;
}
