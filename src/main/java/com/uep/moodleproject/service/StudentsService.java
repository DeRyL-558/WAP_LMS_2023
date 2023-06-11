package com.uep.moodleproject.service;

import com.uep.moodleproject.dto.StudentDTO;
import com.uep.moodleproject.model.Student;
import com.uep.moodleproject.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsService
{
    /*@Autowired
    private StudentsRepository studentsRepository;

    public void addStudent(StudentDTO studentDTO)
    {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setPoints(studentDTO.getPoints());
        studentsRepository.save(student);
        System.out.println("Students added!");
    }

    public Iterable<Student> getAllStudents() { return studentsRepository.findAll(); }*/
}
