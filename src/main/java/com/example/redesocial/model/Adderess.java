package com.example.redesocial.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "excluded")
    @Builder.Default
    private boolean excluded = false;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
