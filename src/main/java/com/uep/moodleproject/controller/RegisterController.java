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

import java.util.List;

@Controller
@RequestMapping(path = "/register")
public class RegisterController
{
    private final UserRepository userRepository;
    public String warning_login;
    public String warning_password;

    @Autowired
    public RegisterController(UserRepository userRepository) { this.userRepository = userRepository; }

    @GetMapping
    private String registerPage(Model model, HttpSession hhtpSession)
    {
        model.addAttribute("warning_login", warning_login);
        model.addAttribute("warning_password", warning_password);
        return "register";
    }

    @PostMapping
    private String addAccount(User user)
    {
        List<User> userFromDatabase = userRepository.findByLogin(user.getLogin());

        if (!userFromDatabase.isEmpty())
        {
            warning_login = "This login is claimed!";
            return "redirect:/register";
        }

        if (user.getPassword() != user.getPassword())
        {
            warning_password = "Passwords are different!";
            return "redirect:/register";
        }

        warning_login = "";
        warning_password = "";
        userRepository.save(user);
        return "redirect:/";
    }
}
