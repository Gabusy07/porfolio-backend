package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "work_experiences")
@ToString
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter  @Column(name = "id")
    private int id;

    @Getter
    @Setter
    @Column(name = "title")
    private String title;

    @Getter
    @Setter
    @Column(name = "place")
    private String place;

    @Getter
    @Setter
    @Column(name = "description")
    private String description;

    private String language;
}
