package com.gmr.porfolio.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "user")
@ToString @EqualsAndHashCode
public class User {

    @Id
    @Getter
    @Setter
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name="name")
    private String name;

    @Getter
    @Setter
    @Column(name="lastname")
    private String lastname;

    @Getter
    @Setter
    @Column(name="nickname")
    private String nickname;

    @Getter
    @Setter
    @Column(name="email")
    private String email;


    @Getter
    @Setter
    @Column(name="password")
    private String password;

    @Getter
    @Setter
    @Column(name="roles")
    private ArrayList<String> roles;

    @Getter
    @Setter
    @Column(name = "points")
    private int points;

    @Getter
    @Setter
    @Column(name = "avatar")
    private String avatar;




}
