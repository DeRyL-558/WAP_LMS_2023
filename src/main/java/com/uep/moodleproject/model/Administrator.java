package com.uep.moodleproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@SecondaryTable(name = "administrators", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))
public class Administrator extends User
{

}
