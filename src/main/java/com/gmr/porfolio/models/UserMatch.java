package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_matches")
@ToString
@Data
public class UserMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;


    @Column(name = "points")
    private int points;


    @Column(name = "avatar")
    private String avatar;



    /*
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User userM;*/


    @Column(name="user_id")
    private Long userID;

}