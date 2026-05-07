package com.student.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name required")
	@Column(nullable = false)
	private String name;

	@Email(message = "Valid email required")
	@Column(nullable = false, unique = true)
	private String email;

	@NotBlank(message = "Course required")
	@Column(nullable = false)
	private String course;

	@Min(value = 15, message = "Age minimum 15")
	@Max(value = 50, message = "Age maximum 50")
	@Column(nullable = false)
	private int age;

	@NotBlank(message = "Phone required")
	@Column(nullable = false)
	private String phone;
}