package com.gmr.porfolio.models;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "description")
@ToString
@Getter
public class Description {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "desc_id")
    private int id;


    @Column(name = "text")
    private String text;


    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "photo")
    private String photo;


    @Column(name = "url_photo")
    private String urlPhoto;

    @Column(name = "language")
    private LanguageEnum language;

    public static class Builder {
        private Description desc = new Description();

        public Description.Builder setId(int id) {
            desc.id = id;
            return this;
        }
        public Description.Builder setTitle(String title) {
            desc.title = title;
            return this;
        }
        public Description.Builder setPhoto(String photo) {
            desc.photo = photo;
            return this;
        }
        public Description.Builder setText(String text) {
            desc.text = text;
            return this;
        }
        public Description.Builder setUrlPhoto(String url) {
            desc.urlPhoto = url;
            return this;
        }
        public Description.Builder setLanguage(LanguageEnum lang) {
            desc.language = lang;
            return this;
        }

        public Description build() {
            return desc;
        }
    }

}
