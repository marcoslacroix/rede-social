package com.example.redesocial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "ddd_cell")
    private Integer dddCell;

    @Column(name = "home_phone")
    private Long homePhone;

    @Column(name = "cell_phone")
    private Long cellPhone;

    @Column(name = "ddd_home")
    private Integer dddHome;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
