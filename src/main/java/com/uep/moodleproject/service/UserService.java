package com.uep.moodleproject.service;

import com.uep.moodleproject.dto.UserDTO;
import com.uep.moodleproject.model.User;
import com.uep.moodleproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public User save(UserDTO userDTO)
    {
        User user = new User(userDTO.getLogin(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getFirst_name(), userDTO.getLast_name(), userDTO.getRoles());
        return userRepository.save(user);
    }
}
