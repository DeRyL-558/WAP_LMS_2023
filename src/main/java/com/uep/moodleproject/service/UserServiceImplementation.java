package com.uep.moodleproject.service;

import com.uep.moodleproject.dto.UserDTO;
import com.uep.moodleproject.model.*;
import com.uep.moodleproject.repository.RoleRepository;
import com.uep.moodleproject.repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User save(UserDTO userDTO)
    {
        Role role = roleRepository.findByRoleName(userDTO.getRole());

        User user = new User(userDTO.getLogin(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getFirst_name(), userDTO.getLast_name(), Collections.singletonList(role));

        if (userDTO.getRole().equals("Student"))
        {
            Student student = new Student(user.getLogin(), user.getPassword(), user.getEmail(), user.getFirst_name(), user.getLast_name(), user.getRoles(), 1, 1, "Unknown", 0);
            return userRepository.save(student);
        }
        else if (userDTO.getRole().equals("Course_coordinator"))
        {
            CourseCoordinator coordinator = new CourseCoordinator(user.getLogin(), user.getPassword(), user.getEmail(), user.getFirst_name(), user.getLast_name(), user.getRoles(), "Unknown");
            return userRepository.save(coordinator);
        }
        else if (userDTO.getRole().equals("Instructor"))
        {
            Instructor instructor = new Instructor(user.getLogin(), user.getPassword(), user.getEmail(), user.getFirst_name(), user.getLast_name(), user.getRoles(), "Unknown");
            return userRepository.save(instructor);
        }
        else
        {
            return userRepository.save(user);
        }
    }
}
