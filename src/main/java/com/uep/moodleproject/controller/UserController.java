package com.uep.moodleproject.controller;

import com.uep.moodleproject.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    private boolean isUserLoggedIn(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }

    @GetMapping(path = "/panel")
    public String panel(Model model, HttpServletRequest request)
    {
        if (!isUserLoggedIn(request))
        {
            return "redirect:/";
        }

        model.addAttribute("users", userRepository.findAll());
        return "panel";
    }
}
