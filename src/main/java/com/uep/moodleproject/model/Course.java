package com.uep.moodleproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "courses")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;

    private String course_name;
    private String faculty;

    public Course(String course_name, String faculty)
    {
        this.course_name = course_name;
        this.faculty = faculty;
    }
}
