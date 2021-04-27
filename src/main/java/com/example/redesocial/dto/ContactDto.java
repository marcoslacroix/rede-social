package com.example.redesocial.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ContactDto {

    private Long id;

    private String uuid;

    private Integer dddCell;

    private Long homePhone;

    private Long cellPhone;

    private Integer dddHome;

    private String email;
}
