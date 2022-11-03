package com.gmr.porfolio.models;

import lombok.*;
import javax.persistence.*;
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
    @OneToMany(mappedBy = "userR")
    @JoinColumn(name = "usersRoles")
    private Set<UserRol> userRol;*/

    @OneToOne(mappedBy = "userM")
    @JoinColumn(name = "points")
    private UserMatch userMatch;



}
