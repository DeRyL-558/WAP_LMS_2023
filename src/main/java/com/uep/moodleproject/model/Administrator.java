package com.uep.moodleproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
@SecondaryTable(name = "administrators", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))
public class Administrator extends User
{
    public Administrator(String login, String password, String email, String first_name, String last_name, List<Role> roles)
    {
        super(login, password, email, first_name, last_name, roles);
    }
}
