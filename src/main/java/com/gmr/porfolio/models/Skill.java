package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "skills")
@ToString
@Getter
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "language", nullable = false)
    private LanguageEnum language;


    public static class Builder {
        private Skill skill = new Skill();

        public Skill.Builder setId(int id) {
            skill.id = id;
            return this;
        }
        public Skill.Builder setName(String name) {
            skill.name = name;
            return this;
        }
        public Skill.Builder setLanguage(LanguageEnum lang) {
            skill.language = lang;
            return this;
        }

        public Skill build() {
            return skill;
        }
    }

}
