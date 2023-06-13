package com.uep.moodleproject.repository;

import com.uep.moodleproject.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long>
{
    @Query("SELECT r FROM Resource r WHERE r.course_id = :courseId")
    List<Resource> findByCourseId(@Param("courseId") Long courseId);
}
