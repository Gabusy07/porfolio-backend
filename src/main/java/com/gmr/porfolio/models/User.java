package com.gmr.porfolio.models;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;

import java.util.List;


@Entity
@Table(name = "users")
@ToString
@Data
public class User {

    @Id
    @Column(name="id")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name="name", nullable = false)
    private String name;


    @Column(name="lastname", nullable = false)
    private String lastname;


    @Column(name="nickname", nullable = false)
    private String nickname;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;


/*
    @OneToOne(mappedBy = "userM", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private UserMatch match = new UserMatch();

    @OneToMany(mappedBy = "userR", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserRol> rol = new ArrayList<>();*/



    private ArrayList<String> roles;


    private int points;

    private String avatar;

}
