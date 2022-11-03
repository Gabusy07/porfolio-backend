package com.gmr.porfolio.models;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "users")
@ToString
@Data
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="name")
    private String name;


    @Column(name="lastname")
    private String lastname;


    @Column(name="nickname")
    private String nickname;


    @Column(name="email")
    private String email;



    @Column(name="password")
    private String password;


/*
    @OneToMany(mappedBy = "user_r")
    @JoinColumn(name = "usersRoles ")
    private Set<UserRol> userRol;*/

    @OneToOne(mappedBy = "user_m")
    @JoinColumn(name = "users_matches")
    private UserMatch userMatch;



}
