package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "knowledges")
@ToString
@Getter
public class Knowledge {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "progressbar", nullable = false)
    private String progressbar;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "width", nullable = false)
    private int width;

    public static class Builder {
        private Knowledge k = new Knowledge();

        public Knowledge.Builder setId(int id) {
            k.id = id;
            return this;
        }
        public Knowledge.Builder setName(String name) {
            k.name = name;
            return this;
        }
        public Knowledge.Builder setProgressbar(String progressbar) {
            k.progressbar = progressbar;
            return this;
        }
        public Knowledge.Builder setDate(String date) {
            k.date = date;
            return this;
        }
        public Knowledge.Builder setWidth(int width) {
            k.width = width;
            return this;
        }


        public Knowledge build() {
            return k;
        }
    }


}
