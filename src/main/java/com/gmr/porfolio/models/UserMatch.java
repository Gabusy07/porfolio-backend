package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_matches")
@ToString
public class UserMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    @Getter
    @Setter
    private int id;


    @Column(name = "match_points")
    @Getter
    @Setter
    private short points;


    @Column(name = "match_avatar")
    @Getter
    @Setter
    private String avatar;


    /*
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User userM;*/


    @Column(name="user_id")
    @Getter
    @Setter
    private int userID;

}