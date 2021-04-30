package com.example.redesocial.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@With
@AllArgsConstructor
@Builder
@Value
@Getter
@Jacksonized
public class UserCreateDto {

    @ApiModelProperty(name = "Nome", example = "Marcos", required = true)
    String name;

    @ApiModelProperty(name = "Sobrenome", example = "Lacroix", required = true)
    String lastName;

    @ApiModelProperty(name = "Email", example = "marcoslacroix@gmail.com", required = true)
    String email;

    @ApiModelProperty(name = "Password", example = "2939239293", required = true)
    String password;

    @ApiModelProperty(name = "Data de nascimento", example = "1993-03-19", required = true)
    LocalDate birthdate;

}
