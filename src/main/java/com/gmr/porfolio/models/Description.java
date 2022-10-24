package com.gmr.porfolio.models;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "description")
@ToString
@EqualsAndHashCode
public class Description {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "text")
    private String text;

    @Getter
    @Setter
    @Column(name = "tittle")
    private String title;

    @Getter
    @Setter
    @Column(name = "photo")
    private String photo;

}
