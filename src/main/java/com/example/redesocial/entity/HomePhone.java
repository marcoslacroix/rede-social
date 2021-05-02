package com.example.redesocial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HomePhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "ddd")
    private Integer ddd;

    @Column(name = "ddi")
    private Integer ddi;

    @Column(name = "home_phone")
    private Long homePhone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
