package com.iamzexy.SpringTestTask.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @author Demin Artem
 */
@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue
    private String id;

    private String login;

    private String fio;

    private String birthdate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Account> accounts;

    public User() {
    }

    public User(String login, String fio, String birthdate, List<Account> accounts) {
        this.login = login;
        this.fio = fio;
        this.birthdate = birthdate;
        this.accounts = accounts;
    }
}
