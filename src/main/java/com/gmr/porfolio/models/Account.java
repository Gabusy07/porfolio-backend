package com.gmr.porfolio.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idaccount", nullable = false)
    private Long id;


    @Getter
    @Setter
    @Column(name = "password")
    private String password;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "adminid")
    private String id_admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
