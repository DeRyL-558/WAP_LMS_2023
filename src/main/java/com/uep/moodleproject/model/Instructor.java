package com.uep.moodleproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
@SecondaryTable(name = "instructors", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))
public class Instructor extends User
{
    @Column(table = "instructors")
    private String i_academic_title;

    public Instructor(String login, String password, String email, String first_name, String last_name, List<Role> roles, String i_academic_title)
    {
        super(login, password, email, first_name, last_name, roles);
        this.i_academic_title = i_academic_title;
    }
}
