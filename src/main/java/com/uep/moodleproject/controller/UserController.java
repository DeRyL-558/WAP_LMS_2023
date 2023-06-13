package com.uep.moodleproject.controller;

import com.uep.moodleproject.model.*;
import com.uep.moodleproject.repository.CourseRepository;
import com.uep.moodleproject.repository.RoleRepository;
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

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CourseRepository courseRepository;

    private boolean isUserLoggedIn(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("user") != null && session.getAttribute("user") instanceof User;
    }

    @GetMapping(path = "/panel")
    public String panel(Model model, HttpServletRequest request)
    {
        if (!isUserLoggedIn(request))
        {
            return "redirect:/";
        }

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        Student student = userRepository.findStudentByUserId(user.getUser_id());
        CourseCoordinator coordinator = userRepository.findCoordinatorByUserId(user.getUser_id());
        Instructor instructor = userRepository.findInstructorByUserId(user.getUser_id());
        Administrator administrator = userRepository.findAdministratorByUserId(user.getUser_id());

        if (student != null)
        {
            model.addAttribute("student", student);
        }

        if (coordinator != null)
        {
            model.addAttribute("coordinator", coordinator);
            model.addAttribute("courses", courseRepository.findAll());
        }

        if (instructor != null)
        {
            model.addAttribute("instructor", instructor);
        }

        if (administrator != null)
        {
            model.addAttribute("administrator", administrator);
            model.addAttribute("courses", courseRepository.findAll());
        }

        model.addAttribute("user", user);
        return "panel";
    }
}
