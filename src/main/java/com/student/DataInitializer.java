package com.student;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    @Bean
    CommandLineRunner initData(StudentRepository repository) {
        return args -> {
            if (repository.count() > 0) {
                log.info("Student data already exists. Skipping sample data.");
                return;
            }

            repository.save(new Student(null, "Ram", "ram@example.com",
                    "Computer Science", 20, "9000000001"));
            repository.save(new Student(null, "Radha", "radha@example.com",
                    "Software Engineering", 21, "9000000002"));
            repository.save(new Student(null, "Krishna", "krishna@example.com",
                    "Computer Science", 22, "9000000003"));
            repository.save(new Student(null, "Sita", "sita@example.com",
                    "Data Science", 19, "9000000004"));
            repository.save(new Student(null, "Hanuman", "hanuman@example.com",
                    "Cyber Security", 23, "9000000005"));

            log.info("Sample student data added successfully.");
        };
    }
}
