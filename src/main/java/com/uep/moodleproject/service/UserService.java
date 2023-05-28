package com.uep.moodleproject.service;

import com.uep.moodleproject.dto.UserDTO;
import com.uep.moodleproject.model.User;

public interface UserService
{
    User save(UserDTO userDTO);
}
