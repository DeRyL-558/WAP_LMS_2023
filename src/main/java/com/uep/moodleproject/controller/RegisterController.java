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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private String registerPage(Model model)
    {
        List<Role> availableRoles = roleRepository.findAllByRoleNameNot("Administrator");

        model.addAttribute("users", new UserDTO());
        model.addAttribute("availableRoles", availableRoles);
        return "register";
    }

    @PostMapping
    private String addAccount(@ModelAttribute("user")UserDTO userDTO, RedirectAttributes redirectAttributes)
    {
        List<User> usersFromDatabase = userRepository.findByLogin(userDTO.getLogin());

        if (!usersFromDatabase.isEmpty())
        {
            redirectAttributes.addAttribute("warning_login", true);
            return "redirect:/register";
        }

        /*if (userDTO.getPassword() != userDTO.getPassword()) { return "redirect:/register"; }*/

        User user = userService.save(userDTO);
        return "redirect:/sign-in";


        /*if (userDTO.setRole() == "Instructor")
        {
            return "redirect:/register-notification";
        }*/
    }
}
