package com.gmr.porfolio.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@ToString
@EqualsAndHashCode
public class Admin_user extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "user_id")
    private Long user_id;
    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "lastname")
    private String lastname;

    @Getter @Setter @Column(name = "password")
    private String password;

    @Getter @Setter @Column(name = "nickname")
    private String nickname;

    @Getter @Setter @Column(name = "email")
    private String email;


}
