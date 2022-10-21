package com.gmr.porfolio.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "User_match")
@ToString
@EqualsAndHashCode
public class UserMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "points")
    private int points;

    @Getter
    @Setter
    @Column(name = "avatar")
    private String avatar;

    @Getter
    @Setter
    @Column(name = "user_id")
    private Long user_id;

}
