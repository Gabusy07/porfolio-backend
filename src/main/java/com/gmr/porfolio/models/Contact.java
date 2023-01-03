package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Column(name = "cont_id")
    private int id;

    @Getter @Setter
    @Column(name = "icon")
    private String icon;

    @Getter @Setter @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "link")
    private String link;

    @Getter @Setter @Column(name = "profile_id")
    private int profile_id;



}
