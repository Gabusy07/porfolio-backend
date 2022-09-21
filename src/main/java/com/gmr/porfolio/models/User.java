package com.gmr.porfolio.models;

import lombok.Getter;
import lombok.Setter;

public class User {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String lastname;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String email;

}
