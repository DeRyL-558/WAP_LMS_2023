package com.uep.moodleproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
@SecondaryTable(name = "students", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))
public class Student extends User
{
    @Column(table = "students")
    private Integer year;

    @Column(table = "students")
    private Integer semester;

    @Column(table = "students")
    private String student_faculty;

    @Column(table = "students")
    private Integer points;

    public Student(String login, String password, String email, String first_name, String last_name, List<Role> roles, Integer year, Integer semester, String student_faculty, Integer points)
    {
        super(login, password, email, first_name, last_name, roles);
        this.year = year;
        this.semester = semester;
        this.student_faculty = student_faculty;
        this.points = points;
    }
}
