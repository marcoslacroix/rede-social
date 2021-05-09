package com.example.redesocial.dto.work.update;

import io.swagger.annotations.ApiModelProperty;
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
public class WorkUpdateDto {


    @ApiModelProperty(name = "Id of work", example = "4", required = true)
    Long id;

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

    @ApiModelProperty(hidden = true, name = "Date you left the company")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate end;

}
