package com.gmr.porfolio.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@ToString @EqualsAndHashCode
public class User {

    @Id
    @Getter
    @Setter
    @Column(name="id")
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
    @Column(name="password")
    private String password;

    @Getter
    @Setter
    @Column(name="email")
    private String email;

}
