package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



public class User {

    private int id;
    @Getter @Setter
    private String name;

    @Getter @Setter
    private String lastname;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private String email;

}

