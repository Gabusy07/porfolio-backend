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
    private Long id;


    @Column(name = "rol")
    private String rol;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_r;
}
