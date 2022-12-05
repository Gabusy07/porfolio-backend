package com.gmr.porfolio.models;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@ToString
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;


    @Column(name="user_name", nullable = false)
    @Getter
    @Setter
    private String name;


    @Column(name="user_lastname", nullable = false)
    @Getter
    @Setter
    private String lastname;


    @Column(name="user_nickname", nullable = false)
    @Getter
    @Setter
    private String nickname;

    @Column(name="user_email", nullable = false, unique = true)
    @Getter
    @Setter
    private String email;

    @Column(name="user_password", nullable = false)
    @Getter
    @Setter
    private String password;


/*
    @OneToOne(mappedBy = "userM", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private UserMatch match = new UserMatch();

    @OneToMany(mappedBy = "userR", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserRol> rol = new ArrayList<>();*/

    @Getter
    @Setter
    private ArrayList<String> roles;

    @Getter
    @Setter
    private int points;

    @Getter
    @Setter
    private String avatar;

}
