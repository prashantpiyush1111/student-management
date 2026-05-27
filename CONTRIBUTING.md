# Contributing to Student Management System

Thank you for your interest in contributing! Please follow the steps below carefully.

---

## Step 1: Fork the Repository

Click the Fork button on the top right of this page.
This creates a copy of the repo in your GitHub account.

---

## Step 2: Clone Your Fork

git clone https://github.com/YOUR_USERNAME/student-management.git
cd student-management

---

## Step 3: Create a New Branch

Never commit directly to main. Always create a new branch.

git checkout -b feature/your-feature-name

Branch naming rules:
- New feature  → feature/your-feature-name
- Bug fix       → fix/your-bug-name
- Documentation → docs/your-doc-name

---

## Step 4: Setup the Project Locally

1. Start MySQL and create database:
   CREATE DATABASE IF NOT EXISTS studentdb;

2. Create src/main/resources/application.properties:
   server.port=8082
   spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update

3. Create .env file in root:
   ADMIN_USERNAME=your_username
   ADMIN_PASSWORD=your_password
   DB_URL=jdbc:mysql://localhost:3306/studentdb
   DB_USERNAME=root
   DB_PASSWORD=your_password
   PORT=8082

4. Run the project:
   mvn spring-boot:run

5. Open browser:
   http://localhost:8082

---

## Step 5: Make Your Changes

- Follow standard Java naming conventions
- Add comments where necessary
- Keep methods small and focused
- Do not push application.properties or .env files

---

## Step 6: Commit Your Changes

git add .
git commit -m "Add: brief description of your change"

---

## Step 7: Push Your Branch

git push origin feature/your-feature-name

---

## Step 8: Raise a Pull Request

1. Go to the original repo on GitHub
2. Click New Pull Request
3. Select your branch
4. Fill in the PR description properly

---

## PR Description Rules (Very Important!)

Your PR will be automatically checked by Prashant's PR Checker Bot.
The bot will reject your PR if:

- You have not linked an issue
- Your description is too short

Always write like this in your PR description:

Fixes #ISSUE_NUMBER

Brief description of what you changed and why.

Example:

Fixes #2

Added search functionality to filter students by course name.
The search bar on dashboard now filters results in real time without page reload.

---

## Step 9: Wait for Review

Once your PR passes the bot check it will get the ready-for-review label.
Then wait for Prashant to review and merge your PR.

---

## Need Help?

Open a new issue and describe your problem clearly.
Label it as question or help wanted.
