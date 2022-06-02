package com.iamzexy.SpringTestTask.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Demin Artem
 */
@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue
    private String id;

    private String balance;

    public Account() {
    }
}
