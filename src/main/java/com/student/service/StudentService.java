package com.student.service;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student updateStudent(Long id, Student updatedStudent) {
		Student existing = studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student nahi mila ID: " + id));

		existing.setName(updatedStudent.getName());
		existing.setEmail(updatedStudent.getEmail());
		existing.setCourse(updatedStudent.getCourse());
		existing.setAge(updatedStudent.getAge());
		existing.setPhone(updatedStudent.getPhone());

		return studentRepository.save(existing);
	}

	public void deleteStudent(Long id) {
		if (!studentRepository.existsById(id)) {
			throw new RuntimeException("Student nahi mila ID: " + id);
		}
		studentRepository.deleteById(id);
	}

	public List<Student> getStudentsByCourse(String course) {
		return studentRepository.findByCourse(course);
	}

	public List<Student> searchStudentsByName(String name) {
		return studentRepository.findByNameContainingIgnoreCase(name);
	}
}
