package com.example.redesocial.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Value
@Getter
@Jacksonized
public class ContactDto {

    Long id;

    String uuid;

    Integer dddCell;

    Long homePhone;

    Long cellPhone;

    Integer dddHome;

    String email;
}
