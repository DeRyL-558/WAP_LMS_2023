package com.uep.moodleproject.controller;

import com.uep.moodleproject.dto.UserDTO;
import com.uep.moodleproject.model.Role;
import com.uep.moodleproject.model.User;
import com.uep.moodleproject.repository.RoleRepository;
import com.uep.moodleproject.repository.UserRepository;
import com.uep.moodleproject.service.UserServiceImplementation;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/register")
public class RegisterController
{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private UserServiceImplementation userService;

    @Autowired
    public RegisterController(UserRepository userRepository, UserServiceImplementation userService, RoleRepository roleRepository)
    {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @GetMapping
    private String registerPage(Model model, HttpSession hhtpSession)
    {
        List<Role> availableRoles = roleRepository.findAllByRoleNameNot("Administrator");

        model.addAttribute("users", new UserDTO());
        model.addAttribute("availableRoles", availableRoles);
        return "register";
    }

    @PostMapping
    private String addAccount(@ModelAttribute("users")UserDTO userDTO)
    {
        List<User> userFromDatabase = userRepository.findByLogin(userDTO.getLogin());

        if (!userFromDatabase.isEmpty()) { return "redirect:/register?warning_login"; }

        if (userDTO.getPassword() != userDTO.getPassword()) { return "redirect:/register"; }

        userService.save(userDTO);
        return "redirect:/";
        /*if (userDTO.getRoles() == 3)
        {
            return "redirect:/register-notification";
        }
        else
        {
            return "redirect:/";
        }*/
    }
}
