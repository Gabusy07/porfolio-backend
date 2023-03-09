package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "app_config")
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppConfig {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @OneToOne
    @JoinColumn(name = "language_id")
    private Language lang;

    @OneToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;
}
