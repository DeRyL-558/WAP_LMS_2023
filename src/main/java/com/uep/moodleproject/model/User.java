package com.uep.moodleproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue
    private Long user_id;

    private String login;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private Integer type_id;

    public User(String login, String password, String email, String first_name, String last_name, Integer type_id)
    {
        this.login = login;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.type_id = type_id;
    }
}
