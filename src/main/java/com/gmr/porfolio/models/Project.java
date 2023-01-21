package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "projects")
@ToString
@Getter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "link_project")
    private String linkProject;


    @Column(name = "language")
    private LanguageEnum language;


    public static class Builder {
        private Project project = new Project();
        public Project.Builder setTitle(String title) {
            project.title = title;
            return this;
        }
        public Project.Builder setDescription(String description) {
            project.description = description;
            return this;
        }
        public Project.Builder setImage(String image) {
            project.image = image;
            return this;
        }
        public Project.Builder setLinkProject(String linkProject) {
            project.linkProject = linkProject;
            return this;
        }
        public Project.Builder setLanguage(LanguageEnum lang) {
            project.language = lang;
            return this;
        }

        public Project build() {
            return project;
        }
    }

}
