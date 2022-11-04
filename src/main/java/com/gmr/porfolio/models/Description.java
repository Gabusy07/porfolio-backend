package com.gmr.porfolio.models;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "description")
@ToString
@EqualsAndHashCode
@Data
public class Description {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "text")
    private String text;


    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "photo")
    private String photo;


    @Column(name = "name_photo")
    private String namePhoto;

}
