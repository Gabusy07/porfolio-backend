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
    @Setter
    private int id;


    @Column(name = "desc_text")
    @Getter
    @Setter
    private String text;


    @Column(name = "desc_title", nullable = false)
    @Getter
    @Setter
    private String title;


    @Column(name = "desc_photo")
    @Getter
    @Setter
    private String photo;


    @Column(name = "desc_url_photo")
    @Getter
    @Setter
    private String urlPhoto;

}
