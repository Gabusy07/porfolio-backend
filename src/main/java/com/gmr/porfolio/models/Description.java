package com.gmr.porfolio.models;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "description")
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
