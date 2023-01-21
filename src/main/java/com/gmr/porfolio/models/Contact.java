package com.gmr.porfolio.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@ToString
@Getter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cont_id")
    private int id;

    @Column(name = "icon")
    private String icon;

    @Column(name = "name")
    private String name;

    @Column(name = "link")
    private String link;

    public static class Builder {
        private Contact contact = new Contact();
        public Contact.Builder setIcon(String icon) {
            contact.icon = icon;
            return this;
        }
        public Contact.Builder setName(String name) {
            contact.name = name;
            return this;
        }
        public Contact.Builder setLink(String link) {
            contact.link = link;
            return this;
        }

        public Contact build() {
            return contact;
        }
    }

}
