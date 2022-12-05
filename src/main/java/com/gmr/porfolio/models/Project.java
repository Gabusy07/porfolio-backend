package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "project_id")
    private int id;

    @Getter @Setter
    @Column(name = "title")
    private String title;

    @Getter @Setter @Column(name = "project_image")
    private String image;

    @Getter @Setter @Column(name = "profile_id")
    private Long profile_id;

}
