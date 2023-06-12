package com.uep.moodleproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@SecondaryTable(name = "instructors", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))
public class Instructor extends User
{
    @Column(table = "instructors")
    private String i_academic_title;
}
