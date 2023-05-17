package com.uep.moodleproject.repository;

import com.uep.moodleproject.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends CrudRepository<Student, Integer> {}
