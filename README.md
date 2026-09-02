# 🎓 Student Management System

> A secure Java Spring Boot application for managing student records with authentication, role-based access, validation, search, and a lightweight web dashboard.

## 📌 Overview

The **Student Management System** is a backend-focused web application built with **Java, Spring Boot, Spring Security, and MySQL**. It provides authenticated operations for managing student records through REST APIs and a simple HTML-based interface.

The project demonstrates practical Spring Boot fundamentals including layered application design, JPA persistence, security configuration, validation, and environment-based configuration.

## ✨ Features

| Feature | Description |
|---|---|
| 🔐 Authentication | Login/logout with Spring Security |
| 👥 Authorization | Role-based access with ADMIN-only deletion |
| 🎓 Student Management | Add, edit, search, view, and delete students |
| 🔎 Search & Filters | Search by name/email and filter by course |
| 📊 Dashboard | Student statistics and overview |
| ✅ Validation | Input validation for student operations |
| 🗄️ Persistence | MySQL database with Spring Data JPA |
| 🔒 Security | BCrypt password encoding, CSRF protection, session controls |
| ⚙️ Configuration | Credentials and deployment settings via environment variables |

## 🏗️ Architecture

```text
HTML Frontend
      │
      │ HTTP / REST
      ▼
┌─────────────────────┐
│ Spring Boot         │
│ Controller Layer    │
└──────────┬──────────┘
           ▼
┌─────────────────────┐
│ Service Layer       │
│ Business Logic      │
└──────────┬──────────┘
           ▼
┌─────────────────────┐
│ Repository Layer    │
│ Spring Data JPA     │
└──────────┬──────────┘
           ▼
      MySQL Database
```

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Application language |
| Spring Boot 3.2.0 | Application framework |
| Spring Security 6.x | Authentication and authorization |
| Spring Data JPA 3.x | Persistence and database access |
| MySQL 8.x | Relational database |
| Lombok | Boilerplate reduction |
| Maven 3.x | Build and dependency management |
| HTML/CSS/JavaScript | Frontend interface |

## 📂 Project Structure

```text
src/main/
├── java/com/student/
│   ├── StudentManagementApplication.java
│   ├── DataInitializer.java
│   ├── config/
│   │   └── SecurityConfig.java
│   ├── model/
│   │   ├── Student.java
│   │   └── Admin.java
│   ├── repository/
│   │   ├── StudentRepository.java
│   │   └── AdminRepository.java
│   ├── service/
│   │   └── StudentService.java
│   └── controller/
│       ├── StudentController.java
│       └── DashboardController.java
└── resources/
    ├── application.properties
    ├── application-prod.properties
    └── static/
        ├── login.html
        ├── dashboard.html
        └── index.html
```

## 🌐 REST API

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/students` | List students |
| GET | `/api/students/{id}` | Get a student |
| POST | `/api/students` | Add a student |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student (ADMIN) |
| GET | `/api/students/search?name=...` | Search by name |
| GET | `/api/students/course/{course}` | Filter by course |

Protected operations require authentication according to the application's security configuration.

## 🚀 Local Setup

### Prerequisites

- Java 17
- Maven 3.x
- MySQL 8.x

### 1. Create Database

```sql
CREATE DATABASE IF NOT EXISTS studentdb;
```

### 2. Configure Environment

Keep credentials in environment variables rather than committing secrets.

Example values:

```text
ADMIN_USERNAME=your_username
ADMIN_PASSWORD=your_strong_password
DB_URL=jdbc:mysql://localhost:3306/studentdb
DB_USERNAME=root
DB_PASSWORD=your_password
PORT=8082
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

### 4. Open the Application

```text
http://localhost:8082/
```

## 🔒 Security

The project includes:

- Spring Security authentication
- BCrypt password encoding
- Role-based authorization
- CSRF protection
- Session management
- Environment-based credentials
- Production-oriented error handling

> Never commit `.env`, production credentials, API keys, or local database passwords.

## 🌐 Deployment

The project includes configuration guidance for deployment on **Render**, including environment variables and Maven build/start commands.

## 📚 Learning Outcomes

This project demonstrates practical experience with:

- Spring Boot REST API development
- Spring Security configuration
- JPA/Hibernate persistence
- MySQL database integration
- Role-based authorization
- Validation and error handling
- Environment-based configuration

## 👨‍💻 Author

**Prashant Maurya**  
Java Full Stack Developer

GitHub: [@prashantpiyush1111](https://github.com/prashantpiyush1111)

## 📄 License

See the repository license for current usage terms.
