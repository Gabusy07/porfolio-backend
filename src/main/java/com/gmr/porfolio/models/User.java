package com.gmr.porfolio.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "users")
@ToString
@Getter
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="lastname", nullable = false)
    private String lastname;

    @Column(name="nickname", nullable = false)
    private String nickname;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    private User() {}

    public static class Builder {
        private User user = new User();

        public Builder setId(int id) {
            user.id = id;
            return this;
        }
        public Builder setName(String username) {
            user.name = username;
            return this;
        }
        public Builder setEmail(String email) {
            user.email = email;
            return this;
        }
        public Builder setLastname(String lastname) {
            user.lastname = lastname;
            return this;
        }
        public Builder setNickname(String nickname) {
            user.nickname = nickname;
            return this;
        }
        public Builder setPassword(String password) {
            user.password = password;
            return this;
        }

        public User build() {
            return user;
        }
    }
}

