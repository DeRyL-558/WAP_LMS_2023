package com.uep.moodleproject.controller;

import com.uep.moodleproject.model.Course;
import com.uep.moodleproject.model.Resource;
import com.uep.moodleproject.repository.CourseRepository;
import com.uep.moodleproject.repository.ResourceRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CourseController
{
    private CourseRepository courseRepository;
    private ResourceRepository resourceRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository, ResourceRepository resourceRepository)
    {
        this.courseRepository = courseRepository;
        this.resourceRepository = resourceRepository;
    }
    @GetMapping(path = "/courses/it")
    public String ItCourses(Model model)
    {
        List<Course> itCourses = courseRepository.findByCourseFaculty("IT Department");
        model.addAttribute("courses", itCourses);
        return "courselist";
    }

    @GetMapping(path = "courses/{courseId}")
    public String CoursePage(@PathVariable("courseId") Long courseId, Model model)
    {
        Course course = courseRepository.findByCourseId(courseId);
        List<Resource> resources = resourceRepository.findByCourseId(courseId);

        model.addAttribute("course", course);
        model.addAttribute("resources", resources);
        return "course";
    }

    @GetMapping(path = "/courses/management")
    public String ManagementCourses(Model model)
    {
        List<Course> managementCourses = courseRepository.findByCourseFaculty("Faculty of Management");
        model.addAttribute("courses", managementCourses);
        return "courselist";
    }

    @GetMapping(path = "/courses/humanities")
    public String HumanitiesCourses(Model model)
    {
        List<Course> humanitiesCourses = courseRepository.findByCourseFaculty("Faculty of Humanities");
        model.addAttribute("courses", humanitiesCourses);
        return "courselist";
    }

    @GetMapping(path = "/my-courses/course-1")
    public String my_course(Model model, HttpSession hhtpSession) { return "my-courses/course"; }
}
