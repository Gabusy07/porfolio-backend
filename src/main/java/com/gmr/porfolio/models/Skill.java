package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "type")
    private String type;

    @Getter @Setter @Column(name = "profile_id")
    private Long profile_id;

    @Getter @Setter @Column(name = "profile_account_id")
    private Long account_id;

    @Getter @Setter @Column(name = "profile_account_admin_id")
    private Long admin_id;
}
