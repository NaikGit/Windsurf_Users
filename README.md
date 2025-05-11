# Windsurf Users

A Spring Boot REST API for managing users, using an external placeholder API as a backend data source.

## Features
- Retrieve all users
- Retrieve a user by ID
- Create a new user

## Endpoints
Base URL: `http://localhost:8080/api/users`

| Method | Endpoint              | Description           |
|--------|-----------------------|-----------------------|
| GET    | `/api/users`          | Get all users         |
| GET    | `/api/users/{id}`     | Get user by ID        |
| POST   | `/api/users`          | Create a new user     |

## Getting Started

### Prerequisites
- Java 21 or higher
- Maven (or use the included `mvnw` wrapper)

### Build & Run
```bash
./mvnw clean package
./mvnw spring-boot:run
```

The application will start on [http://localhost:8080](http://localhost:8080).

## Example Requests

### Get All Users
```bash
curl http://localhost:8080/api/users
```

### Get User by ID
```bash
curl http://localhost:8080/api/users/1
```

### Create User
```bash
curl -X POST http://localhost:8080/api/users \
     -H "Content-Type: application/json" \
     -d '{"name": "John Doe", "email": "john@example.com"}'
```

## Project Structure
- `controller/` — REST controllers
- `service/` — Business logic and API integration
- `model/` — User data model

## License
MIT
