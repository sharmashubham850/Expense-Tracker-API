# Expense Tracker API

A REST API for tracking expenses with builtin User Authentication.

## Tools Used
- Java11
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT Authentication
- PostgreSQL

### Steps to run project locally

Clone the project

```bash
  git clone https://github.com/sharmashubham850/Expense-Tracker-API
```

Go to the project directory

```bash
  cd Expense-Tracker-API
```

Create Properties file

```bash
  mkdir -p src/main/resources
  touch application.properties
```

- Edit application.properties file with you DB credentials

Start the server (Default PORT=8080)

```bash
  ./mvnw spring-boot:run
```
