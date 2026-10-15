# Employee Task and Project Management System

A backend application built with Java and Spring Boot to manage employees, projects, tasks, and comments.

## Technologies Used
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Spring Security
- Maven
- REST APIs

## Implemented Features
- User creation and management
- Project CRUD operations
- Task CRUD operations
- Comments management
- Login API with password verification
- BCrypt password hashing
- Request validation for user data
- Centralized validation error responses
- MySQL database integration

## Configuration

Configure the following environment variables locally:

- `DB_PASSWORD` — your MySQL database password

The database connection settings are in `src/main/resources/application.properties`.

## Run Locally

1. Install Java 21 and ensure MySQL is running.
2. Create a database named `employee_management`.
3. Configure the `DB_PASSWORD` environment variable.
4. From the project root, run:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

5. The backend runs on `http://localhost:8080`.

## Project Status

Backend CRUD APIs and basic login and validation are implemented. Role-based authorization and the React frontend are planned improvements.

## Developer

Beemagoni Varun