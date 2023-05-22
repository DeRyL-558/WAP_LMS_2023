package com.uep.moodleproject.service;

import com.uep.moodleproject.dto.UserDTO;
import com.uep.moodleproject.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService
{
    User save(UserDTO userDTO);
}
