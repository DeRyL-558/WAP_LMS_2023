package com.uep.moodleproject;

import com.uep.moodleproject.model.Course;
import com.uep.moodleproject.repository.CourseRepository;
import com.uep.moodleproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.uep.moodleproject.model.User;

import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner
{
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public DbInit(UserRepository userRepository, CourseRepository courseRepository)
    {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        /*userRepository.saveAll(List.of(
                new User("jkowalski", "dupa123", "jkowalski@xyz.com", "Jan", "Kowalski", 2),
                new User("anowak", "zaq1@WSX", "anowak@xyz.com", "Ania", "Nowak", 3),
                new User("blkarate", "qwerty69", "blee@xyz.com", "Bruce", "Lee", 4)
        ));

        courseRepository.saveAll(List.of(
                new Course("Algorithms", "IT Department"),
                new Course("Numerical Methods", "IT Department"),
                new Course("Graphics and Visualization", "IT Department")
        ));*/

    }
}
