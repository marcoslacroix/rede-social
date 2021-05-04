package com.example.redesocial.entity;

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
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "ddd")
    private Integer ddd;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "ddi_phone")
    private Integer ddiPhone;

    @Column(name = "ddd_home_phone")
    private Integer dddHomePhone;

    @Column(name = "home_phone")
    private Long homePhone;

    @Column(name = "ddi_home_phone")
    private Integer ddiHomePhone;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
