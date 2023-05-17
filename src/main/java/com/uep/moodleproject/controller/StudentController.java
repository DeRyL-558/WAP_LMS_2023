package com.uep.moodleproject.controller;

import com.uep.moodleproject.dto.StudentDTO;
import com.uep.moodleproject.model.Student;
import com.uep.moodleproject.service.StudentsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class StudentController
{
    private final StudentsService studentsService;

    public StudentController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping(path = "/hello")
    public String sayHello() { return "Hello!"; }


    @GetMapping(path = "/students")
    public Iterable<Student> getAllStudents(){ return studentsService.getAllStudents(); }

    @PostMapping(path = "/students")
    public String addStudents(@RequestBody StudentDTO studentDTO)
    {
        studentsService.addStudent(studentDTO);
        return "Students added";
    }
}
