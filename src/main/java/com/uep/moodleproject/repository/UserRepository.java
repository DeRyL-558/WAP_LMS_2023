package com.uep.moodleproject.repository;

import com.uep.moodleproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    List<User> findByLogin(String login);

    List<User> findByEmail(String email);
}
