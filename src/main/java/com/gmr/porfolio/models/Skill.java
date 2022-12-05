package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "skills")
@ToString
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    @Getter
    @Setter
    private int id;


    @Column(name = "skill_name", nullable = false)
    @Getter
    @Setter
    private String name;

}
