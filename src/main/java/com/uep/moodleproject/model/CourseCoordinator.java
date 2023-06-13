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
@SecondaryTable(name = "course_coordinators", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))
public class CourseCoordinator extends User
{
    @Column(table = "course_coordinators")
    private String cc_academic_title;

    public CourseCoordinator(String login, String password, String email, String first_name, String last_name, List<Role> roles, String cc_academic_title)
    {
        super(login, password, email, first_name, last_name, roles);
        this.cc_academic_title = cc_academic_title;
    }
}
