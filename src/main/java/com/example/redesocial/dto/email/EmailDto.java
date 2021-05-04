package com.example.redesocial.dto.email;

import com.example.redesocial.dto.user.UserDto;
import com.example.redesocial.entity.User;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@With
@AllArgsConstructor
@Builder
@Value
@Getter
@Jacksonized
public class EmailDto {

    Long id;

    String uuid;

    String email;

    boolean excluido;

    UserDto user;
}
