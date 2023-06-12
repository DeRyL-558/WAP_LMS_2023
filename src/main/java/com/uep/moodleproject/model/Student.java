package com.uep.moodleproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@SecondaryTable(name = "students", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))
public class Student extends User
{
    /*@Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "points")
    private Integer points;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public void setId(long  id) { this.id = id; }
    public long getId(){
        return id;
    }

    public Student() {}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Student(String name, Integer points) {}*/
    @Column(table = "students", columnDefinition = "INTEGER DEFAULT 1")
    private Integer year;

    @Column(table = "students", columnDefinition = "INTEGER DEFAULT 1")
    private Integer semester;

    @Column(table = "students", columnDefinition = "VARCHAR(100) DEFAULT 'Unknown'")
    private String student_faculty;

    @Column(table = "students", columnDefinition = "INTEGER DEFAULT 0")
    private Integer points;
}
