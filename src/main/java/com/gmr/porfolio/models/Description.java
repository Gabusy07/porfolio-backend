package com.gmr.porfolio.models;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "description")
@ToString
public class Description {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "desc_id")
    @Getter
    private int id;


    @Column(name = "text")
    @Getter
    @Setter
    private String text;


    @Column(name = "title", nullable = false)
    @Getter
    @Setter
    private String title;


    @Column(name = "photo")
    @Getter
    @Setter
    private String photo;


    @Column(name = "url_photo")
    @Getter
    @Setter
    private String urlPhoto;

}
