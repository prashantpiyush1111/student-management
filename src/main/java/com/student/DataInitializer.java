package com.student;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(StudentRepository repository) {
        return args -> {

            repository.save(new Student(null, "Ram", "Raam@email.com", "Computer Science", 20, "03001234567"));
            repository.save(new Student(null, "Radha", "Raadha@email.com", "Software Engineering", 21, "03011234567"));
            repository.save(new Student(null, "Krishna", "Krrishna@email.com", "Computer Science", 22, "03021234567"));
            repository.save(new Student(null, "Sita", "Siita@email.com", "Data Science", 19, "03031234567"));
            repository.save(new Student(null, "Hanuman", "Haanuman@email.com", "Cyber Security", 23, "03041234567"));

            System.out.println("Sample data added successfully!");
        };
    }
}