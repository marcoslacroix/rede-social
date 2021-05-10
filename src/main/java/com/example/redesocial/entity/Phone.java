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
    private String ddd;

    @Column(name = "phone")
    private String phone;

    @Column(name = "ddi_phone")
    private String ddiPhone;

    @Column(name = "ddd_home_phone")
    private String dddHomePhone;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "ddi_home_phone")
    private String ddiHomePhone;

    @Column(name = "excluded")
    @Builder.Default
    private boolean excluded = false;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
