package com.example.redesocial.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String uuid;

    private LocalDate birthdate;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private List<ContactDto> contacts;
}
