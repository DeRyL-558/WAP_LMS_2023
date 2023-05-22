package com.uep.moodleproject.controller;

import com.uep.moodleproject.dto.UserDTO;
import com.uep.moodleproject.model.User;
import com.uep.moodleproject.repository.UserRepository;
import com.uep.moodleproject.service.UserService;
import jakarta.annotation.PostConstruct;
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

    private UserService userService;

    @Autowired
    public RegisterController(UserRepository userRepository, UserService userService)
    {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    private String registerPage(Model model, HttpSession hhtpSession)
    {
        model.addAttribute("users", new UserDTO());
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
        /*if (user.getRoles() == 3)
        {
            return "redirect:/register-notification";
        }
        else
        {
            return "redirect:/";
        }*/
    }
}
