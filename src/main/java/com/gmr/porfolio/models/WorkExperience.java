package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "work_experiences")
@ToString
@Getter
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "title")
    private String title;

    @Column(name = "place")
    private String place;

    @Column(name = "description")
    private String description;

    @Column(name = "language")
    private LanguageEnum language;

    private WorkExperience() {}

    public static class Builder {
        private WorkExperience wk = new WorkExperience();
        public WorkExperience.Builder setTitle(String title) {
            wk.title = title;
            return this;
        }
        public WorkExperience.Builder setPlace(String place) {
            wk.place = place;
            return this;
        }
        public WorkExperience.Builder setDescription(String description) {
            wk.description = description;
            return this;
        }
        public WorkExperience.Builder setNickname(LanguageEnum lang) {
            wk.language = lang;
            return this;
        }

        public WorkExperience build() {
            return wk;
        }
    }
}
