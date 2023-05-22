package com.uep.moodleproject.dto;

import com.uep.moodleproject.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class UserDTO
{
    private String login;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private Collection<Role> roles;

    public UserDTO(){}
    public UserDTO(String login, String password, String email, String first_name, String last_name, Collection<Role> roles)
    {
        this.login = login;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.roles = roles;
    }
}
