package com.uep.moodleproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@SecondaryTable(name = "course_coordinators", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))
public class CourseCoordinator extends User
{
    @Column(table = "course_coordinators")
    private String cc_academic_title;
}
