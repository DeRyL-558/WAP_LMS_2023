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
    private String course_faculty;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "user_id")
    private User course_author;

    public Course(String course_name, String course_faculty, User course_author)
    {
        this.course_name = course_name;
        this.course_faculty = course_faculty;
        this.course_author = course_author;
    }
}
