package com.example.redesocial.entity;

import javax.persistence.*;

@Entity
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "like")
    private Long like;

    @Column(name = "love")
    private Long love;

    @Column(name = "sad")
    private Long sad;

    @Column(name = "anger")
    private Long anger;

    @ManyToOne
    @JoinColumn(name = "publication_id", nullable = false)
    private Publication publication;

    @OneToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
