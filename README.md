#  Student Management System

## Java Spring Boot + HTML Frontend

---

## Project Structure

```
student-management/
├── pom.xml
└── src/
    └── main/
        ├── java/com/student/
        │   ├── StudentManagementApplication.java
        │   ├── DataInitializer.java
        │   ├── model/Student.java
        │   ├── repository/StudentRepository.java
        │   ├── service/StudentService.java
        │   └── controller/StudentController.java
        │
        └── resources/
            ├── static/
            │   └── index.html
            └── application.properties
```

---

## How to Run

### Step 1 — Start Backend

```bash
cd student-management
mvn spring-boot:run
```

Server `http://localhost:8082` par chalega
(ensure `application.properties` me `server.port=8082` set ho)

---

### Step 2 — Open Frontend

Open in browser:

```
http://localhost:8082
```

---

## API Endpoints (REST API)

| Method | URL                                     | Description             |
| ------ | --------------------------------------- | ----------------------- |
| GET    | `/api/students`                         | Fetch all students      |
| GET    | `/api/students/{id}`                    | Fetch a student by ID   |
| POST   | `/api/students`                         | Add a new student       |
| PUT    | `/api/students/{id}`                    | Update a student        |
| DELETE | `/api/students/{id}`                    | Delete a student        |
| GET    | `/api/students/search?name=Ahmed`       | Search students by name |
| GET    | `/api/students/course/Computer Science` | Get students by course  |

---

## H2 Database Console

Go to:

```
http://localhost:8082/h2-console
```

* JDBC URL: `jdbc:h2:mem:studentdb`
* Username: `sa`
* Password: (leave empty)

---

## Features

* Student add, edit, and delete functionality
* Search by name, email, and course
* Stats dashboard available
* REST API support (JSON)
* In-memory H2 database (no setup required)
* Sample data auto-loaded

---

