package com.uep.moodleproject.controller;

import com.uep.moodleproject.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController
{
    private final UserRepository userRepository;

    @Autowired
    public HomeController(UserRepository userRepository) { this.userRepository = userRepository; }

    @GetMapping(path = "/")
    public String home(Model model, HttpSession hhtpSession)
    {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping(path = "/register-notification")
    private String registerNotification() { return "register_notification"; }

    //new User(new Integer(1), "xdomin", "dupa123", "Dominik", "Torreto", "cosiki@xyz.com", "student");

    @GetMapping(path = "/courses")
    public String courses(Model model, HttpSession hhtpSession) { return "courses"; }

    @GetMapping(path = "/login")
    public String sign_in() { return "login"; }
}
