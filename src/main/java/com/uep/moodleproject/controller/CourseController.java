package com.uep.moodleproject.controller;

import com.uep.moodleproject.model.Course;
import com.uep.moodleproject.repository.CourseRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CourseController
{
    private CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }
    @GetMapping(path = "/courses/it")
    public String ItCourses(Model model, HttpSession httpSession)
    {
        List<Course> itCourses = courseRepository.findByCourseFaculty("IT Department");
        model.addAttribute("courses", itCourses);
        return "courselist";
    }

    @GetMapping(path = "/courses/management")
    public String ManagementCourses(Model model, HttpSession httpSession)
    {
        List<Course> managementCourses = courseRepository.findByCourseFaculty("Faculty of Management");
        model.addAttribute("courses", managementCourses);
        return "courselist";
    }

    @GetMapping(path = "/courses/humanities")
    public String HumanitiesCourses(Model model, HttpSession httpSession)
    {
        List<Course> humanitiesCourses = courseRepository.findByCourseFaculty("Faculty of Humanities");
        model.addAttribute("courses", humanitiesCourses);
        return "courselist";
    }

    @GetMapping(path = "/my-courses/course-1")
    public String my_course(Model model, HttpSession hhtpSession) { return "my-courses/course"; }
}
