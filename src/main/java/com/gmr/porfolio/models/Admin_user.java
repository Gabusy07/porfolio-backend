package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Admin_user extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "lastname")
    private String lastname;

    @Getter @Setter @Column(name = "password")
    private String password;

    @Getter @Setter @Column(name = "email")
    private String email;


    @Getter @Setter @Column(name = "account_id")
    private int account_id;


}
