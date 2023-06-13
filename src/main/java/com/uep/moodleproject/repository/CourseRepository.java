package com.uep.moodleproject.repository;

import com.uep.moodleproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>
{
    @Query("SELECT c FROM Course c WHERE c.course_faculty = :courseFaculty")
    List<Course> findByCourseFaculty(@Param("courseFaculty") String courseFaculty);

    @Query("SELECT c FROM Course c WHERE c.course_id = :courseId")
    Course findByCourseId(@Param("courseId") Long courseId);
}
