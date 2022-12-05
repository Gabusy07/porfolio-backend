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
    @Setter
    @Column(name = "lan_id")
    private int id;


    @Column(name = "lan_name", nullable = false)
    @Getter
    @Setter
    private String name;

     @Column(name = "lan_progressbar", nullable = false)
     @Getter @Setter
    private String progressbar;

    @Column(name = "lan_date_start", nullable = false)
    @Getter
    @Setter
    private String date_start;

    @Getter @Setter @Column(name = "lan_width", nullable = false)
    private int width;


}
