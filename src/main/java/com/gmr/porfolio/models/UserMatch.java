package com.gmr.porfolio.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "user_match")
@ToString
@EqualsAndHashCode
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

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_m;

}
