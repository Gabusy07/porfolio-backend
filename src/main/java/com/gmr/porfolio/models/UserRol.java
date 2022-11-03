package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "usersRoles")
@ToString
@Data
public class UserRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idRol;


    @Column(name = "rol")
    private String rol;


    @ManyToOne
    @JoinColumn(name = "id_user")
    private User userR;
}