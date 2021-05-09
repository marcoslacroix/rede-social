package com.example.redesocial.dto.work;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@With
@AllArgsConstructor
@Builder
@Value
@Getter
@Jacksonized
public class WorkDto {

    Long id;

    String uuid;

    String company;

    String role;

    String city;

    String description;

    Boolean active;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate start;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate end;

    Long userId;
}
