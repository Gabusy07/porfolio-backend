package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

public class LanguagueJson {


    @Getter
    @Setter
    private Long id;

    @Getter @Setter
    @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "progressbar")
    private String progressbar;

    @Getter @Setter @Column(name = "date_start")
    private String date_start;

}
