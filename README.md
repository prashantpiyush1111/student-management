# 🎓 Student Management System
> Java Spring Boot Backend + HTML Frontend | MySQL Database | Spring Security

---

## 📁 Project Structure

```
student-management/
├── pom.xml                                    ← Maven dependencies
├── README.md                                  ← This file
└── src/main/
    ├── java/com/student/
    │   ├── StudentManagementApplication.java  ← Main class
    │   ├── DataInitializer.java               ← Sample data auto-load
    │   ├── config/
    │   │   └── SecurityConfig.java            ← Spring Security config
    │   ├── model/
    │   │   ├── Student.java                   ← Student entity
    │   │   └── Admin.java                     ← Admin entity
    │   ├── repository/
    │   │   ├── StudentRepository.java         ← Database queries
    │   │   └── AdminRepository.java
    │   ├── service/
    │   │   └── StudentService.java            ← Business logic
    │   └── controller/
    │       ├── StudentController.java         ← REST API endpoints
    │       └── DashboardController.java       ← Page routing
    └── resources/
        ├── application.properties             ← Local config (not in git)
        ├── application-prod.properties        ← Production config
        └── static/
            ├── login.html                     ← Login page
            ├── dashboard.html                 ← Main dashboard
            └── index.html                     ← Root redirect
```

---

## ⚙️ Local Setup

### Step 1 — Start MySQL
```sql
CREATE DATABASE IF NOT EXISTS studentdb;
```

### Step 2 — Create application.properties
Create file at `src/main/resources/application.properties`:
```properties
server.port=8082
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
```

### Step 3 — Create .env File
Create `.env` file in project root:
```
ADMIN_USERNAME=your_username
ADMIN_PASSWORD=your_strong_password
DB_URL=jdbc:mysql://localhost:3306/studentdb
DB_USERNAME=root
DB_PASSWORD=your_password
PORT=8082
```

### Step 4 — Run the Server
```bash
mvn spring-boot:run
```

### Step 5 — Open in Browser
```
http://localhost:8082/
```

---

## 🔐 Login

```
URL:      http://localhost:8082/login.html
Username: value of ADMIN_USERNAME (from .env)
Password: value of ADMIN_PASSWORD (from .env)
```

> ⚠️ Never push .env or application.properties to GitHub!

---

## 🌐 API Endpoints

| Method | URL | Description | Auth |
|--------|-----|-------------|------|
| GET | `/api/students` | Get all students | ✅ Required |
| GET | `/api/students/{id}` | Get student by ID | ✅ Required |
| POST | `/api/students` | Add new student | ✅ Required |
| PUT | `/api/students/{id}` | Update student | ✅ Required |
| DELETE | `/api/students/{id}` | Delete student | 🔒 ADMIN only |
| GET | `/api/students/search?name=Ahmed` | Search by name | ✅ Required |
| GET | `/api/students/course/Computer Science` | Filter by course | ✅ Required |

---

## ✅ Features

| Feature | Status |
|---------|--------|
| Login / Logout | ✅ |
| Spring Security | ✅ |
| Role-based Access (ADMIN only delete) | ✅ |
| CSRF Protection | ✅ |
| Session Management | ✅ |
| Student Add / Edit / Delete | ✅ |
| Search by Name / Email / Course | ✅ |
| Stats Dashboard | ✅ |
| Input Validation | ✅ |
| MySQL Database | ✅ |
| BCrypt Password Encoding | ✅ |
| Environment Variable Credentials | ✅ |

---

## 🚀 Production Deployment (Render)

### Environment Variables — Add in Render Dashboard:
```
ADMIN_USERNAME = your_username
ADMIN_PASSWORD = your_strong_password
DB_URL         = jdbc:mysql://db-host:3306/studentdb
DB_USERNAME    = db_username
DB_PASSWORD    = db_password
PORT           = 8082
```

### Build & Start Commands:
```
Build Command:  mvn clean package -DskipTests
Start Command:  java -jar target/*.jar
```

---

## 🔒 Security

```
✅ application.properties — added to .gitignore
✅ .env — added to .gitignore
✅ Passwords are BCrypt encoded
✅ CSRF protection enabled
✅ Session limit: 1 active session per user
✅ Error details hidden in production
✅ Credentials loaded from environment variables
```

---

## 👨‍💻 Tech Stack

| Technology | Version |
|------------|---------|
| Java | 17 |
| Spring Boot | 3.2.0 |
| Spring Security | 6.x |
| Spring Data JPA | 3.x |
| MySQL | 8.x |
| Lombok | Latest |
| Maven | 3.x |
