package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByCourse(String course);

    List<Student> findByNameContainingIgnoreCase(String name);
}