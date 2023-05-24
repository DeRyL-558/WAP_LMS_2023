package com.uep.moodleproject.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao
{
    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "dromawojciech@gmail.com",
                    "haslo",
                    Collections.singleton(new SimpleGrantedAuthority("Administrator"))
            ),
            new User(
                    "jkowalski@xyz.com",
                    "dupa123",
                    Collections.singleton(new SimpleGrantedAuthority("Student"))
            ),
            new User(
                    "anowak@xyz.com",
                    "zaq1@WSX",
                    Collections.singleton(new SimpleGrantedAuthority("Course_coordinator"))
            ),
            new User(
                    "blee@xyz.com",
                    "qwerty69",
                    Collections.singleton(new SimpleGrantedAuthority("Instructor"))
            )
    );

    public UserDetails findUserByEmail(String email)
    {
        return APPLICATION_USERS.stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user not found"));
    }
}
