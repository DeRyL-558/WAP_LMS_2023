package com.uep.moodleproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructors")
public class Instructor extends User
{

}
