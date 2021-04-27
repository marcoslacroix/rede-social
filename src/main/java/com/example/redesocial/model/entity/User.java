package com.example.redesocial.model.entity;

import lombok.*;
import org.apache.tomcat.jni.Address;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;

    @OneToMany(mappedBy = "user")
    private List<Work> works;

    @OneToMany(mappedBy = "user")
    private List<Adderess> addresses;
}
