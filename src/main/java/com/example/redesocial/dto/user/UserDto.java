package com.example.redesocial.dto.user;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@With
@AllArgsConstructor
@Builder
@Value
@Getter
@Jacksonized
public class UserDto {

    Long id;

    String name;

    String lastName;

    String email;

    String password;

    String uuid;

    LocalDate birthdate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDateTime createdOn;
//
//    private LocalDateTime updatedOn;
//
//    private List<Contact> contacts;
//
//    private List<Work> works;
//
//    private List<Adderess> addresses;
//
//    private List<Publication> publications;
//
//    private List<Comment> comments;
//
//    private List<Collage> collages;
}
