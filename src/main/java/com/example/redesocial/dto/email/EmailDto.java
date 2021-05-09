package com.example.redesocial.dto.email;

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

    Long userId;
}
