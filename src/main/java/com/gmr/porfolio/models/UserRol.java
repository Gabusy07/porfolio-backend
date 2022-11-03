package com.gmr.porfolio.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "user_rol")
@ToString
@EqualsAndHashCode
@Data
public class UserRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "rol")
    private String rol;


    @Column(name = "user_id")
    private Long idUser;
}
