package com.gmr.porfolio.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "language")
@ToString
@EqualsAndHashCode
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "progressbar")
    private String progressbar;

    @Getter @Setter @Column(name = "date_start")
    private Date date_start;

    @Getter @Setter @Column(name = "profile_id")
    private Long profile_id;



}
