package com.example.redesocial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "ddd", nullable = false)
    private Integer ddd;

    @Column(name = "phone", nullable = false)
    private Long phone;

    @Column(name = "ddi")
    private Integer ddi;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
