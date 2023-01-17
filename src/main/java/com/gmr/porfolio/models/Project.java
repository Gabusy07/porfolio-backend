package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "projects")
@ToString
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter  @Column(name = "id")
    private int id;

    @Getter @Setter
    @Column(name = "title")
    private String title;

    @Getter @Setter
    @Column(name = "description")
    private String description;

    @Getter @Setter @Column(name = "image")
    private String image;

    @Getter @Setter @Column(name = "link_project")
    private String linkProject;

    @Getter
    @Setter
    @Column(name = "language")
    private LanguageEnum language;

}
