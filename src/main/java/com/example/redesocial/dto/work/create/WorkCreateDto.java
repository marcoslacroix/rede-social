package com.example.redesocial.dto.work.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@With
@AllArgsConstructor
@Builder
@Value
@Getter
@Jacksonized
public class WorkCreateDto {

    @ApiModelProperty(name = "Name of company you work", example = "TDSOFT", required = true)
    String company;

    @ApiModelProperty(name = "Add the role", example = "Developer")
    String role;

    @ApiModelProperty(name = "Company city name", example = "Florianópolis")
    String city;

    @ApiModelProperty(name = "To describe something", example = "Programing with Java, JavaScript using MYSQL")
    String description;

    @ApiModelProperty(name = "Are active on this company?")
    Boolean active;

    @ApiModelProperty(name = "Date you start on the comapany", example = "2015-05-05", required = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate start;

    @ApiModelProperty(name = "Date you left the company")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate end;

    @ApiModelProperty(name = "Id of user", example = "5", required = true)
    Long userId;
}
