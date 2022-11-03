package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users_matches")
@ToString
@Data
public class UserMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;


    @Column(name = "points")
    private int points;


    @Column(name = "avatar")
    private String avatar;



    @OneToOne
    @JoinColumn(name = "id_user")
    private User userM;

}