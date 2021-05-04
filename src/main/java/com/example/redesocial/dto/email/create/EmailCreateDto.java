package com.example.redesocial.dto.email.create;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@With
@AllArgsConstructor
@Builder
@Value
@Getter
@Jacksonized
public class EmailCreateDto {

    @ApiModelProperty(name = "Email", example = "marcosdaniel@gmail.com", required = true)
    String email;

    @ApiModelProperty(name = "Id do usuário", example = "20", required = true)
    Long userId;
}
