package com.uep.moodleproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController
{
    @GetMapping(path = "/courses/it")
    public String it() {return "it";}
}
