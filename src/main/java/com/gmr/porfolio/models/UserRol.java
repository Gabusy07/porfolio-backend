package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
@ToString
public class UserRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private int idRol;


    @Getter
    @Setter
    @Column(name = "rol_rol")
    private String rol;

/*
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id" , insertable = false, updatable = false)
    private User userR;*/

    @Getter
    @Setter
    @Column(name = "user_id")
    private int userID;
}