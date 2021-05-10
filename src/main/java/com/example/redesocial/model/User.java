package com.example.redesocial.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_principal", nullable = false)
    private String emailPrincipal;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @Column(name = "activated")
    @Builder.Default
    private boolean activated = true;

    @OneToMany(mappedBy = "user")
    private List<Work> works;

    @OneToMany(mappedBy = "user")
    private List<Adderess> addresses;

    @OneToMany(mappedBy = "user")
    private List<Publication> publications;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<Collage> collages;

    @OneToMany(mappedBy = "user")
    private List<Like> likes;

    @OneToMany(mappedBy = "user")
    private List<Email> emails;

    @OneToMany(mappedBy = "user")
    private List<Phone> phones;

    @OneToMany(mappedBy = "user")
    private List<Photo> photos;

}
