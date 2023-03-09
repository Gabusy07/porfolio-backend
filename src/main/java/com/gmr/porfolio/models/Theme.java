package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "themes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Theme {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mode")
    private ThemeMode mode;
}
