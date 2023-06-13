package com.uep.moodleproject.repository;

import com.uep.moodleproject.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    List<User> findByLogin(String login);

    List<User> findByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.user_id = :userId")
    Student findStudentByUserId(@Param("userId") Long userId);

    @Query("SELECT cc FROM CourseCoordinator cc WHERE cc.user_id = :userId")
    CourseCoordinator findCoordinatorByUserId(@Param("userId") Long userId);

    @Query("SELECT i FROM Instructor i WHERE i.user_id = :userId")
    Instructor findInstructorByUserId(@Param("userId") Long userId);

    @Query("SELECT a FROM Administrator a WHERE a.user_id = :userId")
    Administrator findAdministratorByUserId(@Param("userId") Long userId);
}
