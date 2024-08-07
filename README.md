# Task Manager

Task Manager is a simple Spring Boot application for managing tasks. It provides a RESTful API for creating, reading, updating, and deleting tasks.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Database Setup](#database-setup)
- [Usage](#usage)
- [Running Tests](#running-tests)
- [Contributing](#contributing)
- [License](#license)

## Features

- Create a new task
- Retrieve all tasks
- Retrieve a task by ID
- Update a task
- Delete a task

## Technologies Used

- Java 22.0.1
- Spring Boot 2.6.4
- Hibernate
- H2 Database (for testing)
- Maven
- JUnit 4.11

## Prerequisites

- Java 22.0.1
- Maven 3.8+
- Git

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/taskmanager.git
    cd taskmanager
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

## Database Setup

You will need to host/create your own database to match this schema:

```sql
CREATE TABLE tasks (
    id BIGINT NOT NULL AUTO_INCREMENT,
    description VARCHAR(255),
    due_date DATE,
    status VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    password VARCHAR(255),
    role VARCHAR(255),
    username VARCHAR(255),
    PRIMARY KEY (id)
);
```

Using the MySQL Workbench makes this task much easier.


## Usage

1. Run the application:

    ```bash
    mvn spring-boot:run
    ```

2. The application will start on port 8080. You can access the API using a tool like [Postman](https://www.postman.com/) or [cURL](https://curl.se/). I used Postman because it's free for teams of 3 or less and I really liked the GUI.

### API Endpoints

- **GET /api/tasks**: Retrieve all tasks
- **GET /api/tasks/{id}**: Retrieve a task by ID
- **POST /api/tasks**: Create a new task
- **PUT /api/tasks/{id}**: Update a task
- **DELETE /api/tasks/{id}**: Delete a task

## Running Tests

To run the tests, use the following command:

```bash
mvn test
```

## Contributing

Contributions are welcome! Please open an issue or submit a PR for improvements or new features.
Here's some ideas if you're looking to expand (these come from my TODO list):
- [ ] Add Data Transfer Object classes to avoid issues with lazy loading and serialization.
- [ ] Add pagination (10 tasks per 'page') and sorting (sorting by date or alphabetized title).
- [ ] Create a front-end interface (Haven't decided on which to go with, though I'm leaning toward React for a learning experience. If you have any ideas, suggest away!)
- [ ] Improve error handling and validation for API endpoints.
- [ ] Add more comprehensive test coverage.
- [ ] Document the API with Swagger (once again, as a learning experience).
- [ ] Set up CI/CD pipeline for automated testing and deployment.
- [ ] Implement notifications or reminders for task due dates.
- [ ] Add role-based access control (RBAC) for different user permissions.


## License

This project is licensed under the MIT License. 

