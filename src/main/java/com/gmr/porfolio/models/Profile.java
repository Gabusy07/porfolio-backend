package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "account_id")
    private Long account_id;

    @Getter @Setter @Column(name = "account_adminid")
    private Long account_admin_id;



    @Getter @Setter @Column(name = "avatar")
    private String avatar_link;


}
