package com.uep.moodleproject.dto;

import com.uep.moodleproject.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class UserDTO
{
    private String login;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private String role;
    private List<Role> roles;

    public UserDTO(){}
    public UserDTO(String login, String password, String email, String first_name, String last_name, String role)
    {
        this.login = login;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }
}
