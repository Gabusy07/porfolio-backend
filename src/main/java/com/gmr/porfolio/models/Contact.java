package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@ToString
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

}
