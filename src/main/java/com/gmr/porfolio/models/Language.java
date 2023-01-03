package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "languages")
@ToString

public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name = "id")
    private int id;


    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;

     @Column(name = "progressbar", nullable = false)
     @Getter @Setter
    private String progressbar;

    @Column(name = "date", nullable = false)
    @Getter
    @Setter
    private String date;

    @Getter @Setter @Column(name = "width", nullable = false)
    private int width;


}
