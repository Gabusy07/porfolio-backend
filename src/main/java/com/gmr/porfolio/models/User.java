package com.gmr.porfolio.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "users")
@ToString
@NoArgsConstructor
public class User {

    User(String name,String lastname, String nickname, String email, String password){
       this.name = name;
       this.lastname = lastname;
       this.nickname = nickname;
       this.email = email;
       this.password = password;
    }

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;



    @Column(name="name", nullable = false)
    @Getter
    @Setter
    private String name;


    @Column(name="lastname", nullable = false)
    @Getter
    @Setter
    private String lastname;


    @Column(name="nickname", nullable = false)
    @Getter
    @Setter
    private String nickname;

    @Column(name="email", nullable = false, unique = true)
    @Getter
    @Setter
    private String email;

    @Column(name="password", nullable = false)
    @Getter
    @Setter
    private String password;


}
