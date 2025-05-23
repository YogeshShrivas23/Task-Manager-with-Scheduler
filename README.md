# Task Management System

A Spring Boot REST API for managing tasks with an automatic status update scheduler.

## Features

- Create and retrieve tasks
- Automatic task status updates every 6 hours
- PostgreSQL database in production
- H2 in-memory database for development
- RESTful API endpoints

## Prerequisites

- Java 17 or higher
- Maven
- PostgreSQL (for production)

## Local Development

1. Clone the repository
2. Navigate to the project directory
3. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```
4. The application will start on `http://localhost:8080`

## API Documentation

### Create a Task
- **Endpoint**: `POST /tasks`
- **Request Body**:
  ```json
  {
    "title": "Sample Task",
    "description": "This is a sample task description"
  }
  ```
- **Response**: Created task object with ID and timestamps

### Get All Tasks
- **Endpoint**: `GET /tasks`
- **Response**: List of all tasks

## Task Status Flow

Tasks automatically progress through the following statuses every 6 hours:
1. PENDING → IN_PROGRESS
2. IN_PROGRESS → REVIEW
3. REVIEW → COMPLETED
4. COMPLETED (stays as is)

## Environment Variables

The following environment variables are used in production:
- `JDBC_DATABASE_URL`: PostgreSQL connection URL
- `JDBC_DATABASE_USERNAME`: Database username
- `JDBC_DATABASE_PASSWORD`: Database password
- `PORT`: Application port (set by Railway)
- `H2_CONSOLE_ENABLED`: Set to false in production
- `SHOW_SQL`: Set to false in production

## Sample Response

```json
{
  "id": 1,
  "title": "Sample Task",
  "description": "This is a sample task description",
  "status": "PENDING",
  "createdAt": "2024-03-14T10:00:00",
  "updatedAt": "2024-03-14T10:00:00"
}
``` 
