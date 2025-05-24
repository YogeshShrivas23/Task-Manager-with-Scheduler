# Task Management System

A Spring Boot REST API to manage tasks with automatic status updates every 6 hours.  
This project helps teams track task progress efficiently without manual intervention.

## Features
- Create new tasks and fetch existing tasks
- Scheduled task status updates every 6 hours
- Uses PostgreSQL for production
- Uses H2 in-memory database for development
- Clean and simple RESTful API endpoints

## Technologies Used
- Java 17
- Spring Boot
- Maven
- PostgreSQL (Production)
- H2 Database (Development)

## Prerequisites
- Java 17 or higher
- Maven
- PostgreSQL (for production)

# Local Development

1. Clone the repository  
   git clone https://github.com/YogeshShrivas23/Task-Manager-with-Scheduler.git

2. Navigate to the project directory  
   cd Task-Manager-with-Scheduler

3. Run the application using Maven:  
   mvn spring-boot:run

4. The application will start on http://localhost:8080

## API Documentation

### Create a Task
- **Endpoint:** POST /tasks
- **Request Body:**
{
  "title": "Sample Task",
  "description": "This is a sample task description"
}
- **Response:** Returns the created task object with ID, status, and timestamps.

### Get All Tasks
- **Endpoint:** GET /tasks
- **Response:** Returns a list of all tasks with their details.

## How It Works

When you create a task, it starts with the status PENDING.  
A scheduler runs every 6 hours to update task statuses automatically:  
1. PENDING → IN_PROGRESS  
2. IN_PROGRESS → REVIEW  
3. REVIEW → COMPLETED  
4. COMPLETED stays unchanged  

This ensures you don’t need to manually update statuses.

## Environment Variables

For production deployment, configure the following environment variables:  
- JDBC_DATABASE_URL — PostgreSQL connection URL  
- JDBC_DATABASE_USERNAME — Database username  
- JDBC_DATABASE_PASSWORD — Database password  
- PORT — Application port (usually set by the hosting platform)  
- H2_CONSOLE_ENABLED — Set to false in production  
- SHOW_SQL — Set to false in production

## Sample Response

{
  "id": 1,
  "title": "Sample Task",
  "description": "This is a sample task description",
  "status": "PENDING",
  "createdAt": "2024-03-14T10:00:00",
  "updatedAt": "2024-03-14T10:00:00"
}

## Running Tests

To run tests, use:  
mvn test

## Project Structure

- controller — Handles API endpoints  
- service — Contains business logic and scheduler  
- model — Data models/entities  
- repository — Database access layer

## Known Issues

- Scheduler runs at fixed 6-hour intervals; cannot be customized via config currently.  
- No authentication implemented — API is open.

## How to Contribute

Contributions are welcome! Feel free to open issues or submit pull requests.

## License

This project is licensed under the MIT License.

## Contact

If you have any questions or feedback, feel free to reach out:  
- GitHub: https://github.com/YogeshShrivas23  
- Email: yogeshshrivas7566@gmail.com
