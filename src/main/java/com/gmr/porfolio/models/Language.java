package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "languages")
@ToString

@EqualsAndHashCode
@Data

public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;

     @Column(name = "progressbar", nullable = false)
    private String progressbar;

    @Column(name = "date_start", nullable = false)
    private String date_start;

    @Getter @Setter @Column(name = "width", nullable = false)
    private int width;


}
