package com.uep.moodleproject.controller;

import com.uep.moodleproject.model.User;
import com.uep.moodleproject.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/register")
public class RegisterController
{
    private final UserRepository userRepository;

    @Autowired
    public RegisterController(UserRepository userRepository) { this.userRepository = userRepository; }

    @GetMapping
    private String registerPage(Model model, HttpSession hhtpSession)
    {
        return "register";
    }

    @PostMapping
    private String addAccount(User user)
    {
        userRepository.save(user);
        return "redirect:/";
    }
}
