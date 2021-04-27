package com.example.redesocial.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Adderess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "public_place", nullable = false)
    private String publicPlace;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "district", nullable = false)
    private String district;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
