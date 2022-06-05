package com.iamzexy.SpringTestTask.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Demin Artem
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "user_table")
public class User {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_sequence")
    private Long id;

    private String login;

    private String fio;

    private String email;

}
