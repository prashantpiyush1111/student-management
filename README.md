# 🎓 Student Management System
## Java Spring Boot + HTML Frontend

---

## Project Structure (Kya kya hai)

```
student-management/
├── pom.xml                          ← Maven dependencies
├── frontend/
│   └── index.html                   ← Frontend (browser mein kholo)
└── src/main/java/com/student/
    ├── StudentManagementApplication.java  ← Main class
    ├── DataInitializer.java               ← Sample data
    ├── model/
    │   └── Student.java                   ← Database table
    ├── repository/
    │   └── StudentRepository.java         ← Database queries
    ├── service/
    │   └── StudentService.java            ← Business logic
    └── controller/
        └── StudentController.java         ← REST API endpoints
```

---

## Chalane Ka Tarika (How to Run)

### Step 1 — Backend Start Karo
```bash
cd student-management
mvn spring-boot:run
```
Server `http://localhost:8080` par chalu hoga ✅

### Step 2 — Frontend Kholo
`frontend/index.html` ko browser mein open karo
(Double click ya drag karke browser mein daalo)

---

## API Endpoints (REST API)

| Method | URL | Kya karta hai |
|--------|-----|---------------|
| GET | `/api/students` | Saare students laao |
| GET | `/api/students/{id}` | Ek student ID se |
| POST | `/api/students` | Naya student add karo |
| PUT | `/api/students/{id}` | Student update karo |
| DELETE | `/api/students/{id}` | Student delete karo |
| GET | `/api/students/search?name=Ahmed` | Name se search |
| GET | `/api/students/course/Computer Science` | Course ke students |

---

## H2 Database Console
Browser mein jaao: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:studentdb`
- Username: `sa`
- Password: (khaali chhodo)

---

## Features

✅ Student add, edit, delete karo  
✅ Name/email/course se search  
✅ Stats dashboard  
✅ REST API (JSON)  
✅ In-memory H2 database (setup nahi chahiye)  
✅ Sample data auto-load  
Project setup completed 
