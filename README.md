# Tasks API

A Spring Boot 3 RESTful API for managing tasks and authors, crafted with **DDD + Clean Architecture** principles.

## Stack

* Java 21 / Spring Boot 3
* Spring Web, Spring Data JPA, Hibernate Validator
* MySQL 8 (Docker)  
* Maven Wrapper (`mvnw`)  
* Lombok, MapStruct

## Project Layout (Clean Architecture)

```
└─ src/main/java/com/example/tasks
   ├─ domain          # Pure domain models & repositories
   ├─ application     # Use-case services + application exceptions
   ├─ infrastructure  # JPA entities, adapters, mappers, docker config
   ├─ presentation    # REST controllers & DTO contracts
   └─ config          # Spring @Configuration classes
```

## Prerequisites

* Docker + Docker Compose
* (Optional) Local JDK 21 & Maven; otherwise the Makefile uses the Maven wrapper.

## Running the application

Use the provided Makefile.

```bash
# start MySQL container and the Spring Boot app
make start

# when you are done
make stop
```

What happens:
1. `docker compose up -d` launches a MySQL 8 container (`tasksdb`).
2. `./mvnw spring-boot:run` starts the API on **http://localhost:8080**.
3. `make stop` sends SIGINT to Spring Boot (if running) and `docker compose down` stops the database.

> First run will create the schema automatically (`spring.jpa.hibernate.ddl-auto=update`).

## Environment variables / configuration
Edit `src/main/resources/application.properties` for DB credentials if you change the compose file.

## REST Endpoints

| Resource | Method | URL | Body | Notes |
|----------|--------|-----|------|-------|
| Author   | POST   | `/authors` | `{ "name": "Alice" }` | create author |
|          | GET    | `/authors` | – | list all |
|          | GET    | `/authors/{id}` | – | fetch by id |
|          | PUT    | `/authors/{id}` | `{ "name": "Bob" }` | update |
|          | DELETE | `/authors/{id}` | – | delete |
| Task     | POST   | `/tasks` | `{ "name": "Task 1", "dueDate": "2025-12-31", "authorId": 1 }` | create task |
|          | GET    | `/tasks` | – | list all |
|          | GET    | `/tasks/{id}` | – | fetch by id |
|          | PUT    | `/tasks/{id}` | `{ "name": "Task 1 updated", "dueDate": "2026-01-31", "authorId": 1 }` | update |
|          | DELETE | `/tasks/{id}` | – | delete |

### Validation & Error Handling
* Request payloads are validated via Bean Validation (`@NotBlank`, `@NotNull`, `@FutureOrPresent`).
* All errors are returned as JSON with timestamp, status, message, and (for 400) field errors.

```
HTTP/1.1 400 Bad Request
{
  "timestamp": "2025-09-07T21:42:38Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "path": "/tasks",
  "fieldErrors": {
    "name": "must not be blank"
  }
}
```

## Database admin
Access the MySQL container:
```bash
docker exec -it tasks-mysql mysql -uroot -ppassword tasksdb
```