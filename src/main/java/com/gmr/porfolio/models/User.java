package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "iduser")
    private int id;
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

    @Getter @Setter @Column(name = "nickname")
    private String nickname;

    @Getter @Setter @Column(name = "account_id")
    private int account_id;

    @Getter @Setter @Column(name = "match_id")
    private int match_id;

}
}
