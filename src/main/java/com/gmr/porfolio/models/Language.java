package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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

    @Getter @Setter @Column(name = "date_start_learn")
    private Date date_learn;

    @Getter @Setter @Column(name = "profile_id")
    private Long profile_id;

    @Getter @Setter @Column(name = "profile_account_idaccount")
    private Long account_id;

    @Getter @Setter @Column(name = "profile_account_admin_idadmin")
    private Long admin_id;

}
