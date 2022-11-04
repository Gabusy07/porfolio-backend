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
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User userR;

    @Column(name = "user_id")
    private Long userID;
}