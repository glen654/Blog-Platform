# Blog Platform Microservices

## Overview
This project is a **microservices-based blogging platform** where users can write, publish, and comment on blog posts. It consists of three independent services:

- **User Service**: Manages user authentication and profiles.
- **Blog Service**: Handles blog post creation, editing, deletion, and categorization.
- **Comment Service**: Manages comments on blog posts.
- **API Gateway**: Centralized entry point for all services.

## Architecture
The system follows a **microservices architecture** with the following services:

### 1. **User Service**
- Manages user registration and authentication.
- Uses **JWT-based authentication**.
- Handles user roles and profiles.

### 2. **Blog Service**
- Allows users to **create, update, delete, and fetch blog posts**.
- Stores **tags** and **categories** for posts.
- Fetches author details from the **User Service**.
- Calls the **Comment Service** to retrieve comments.

### 3. **Comment Service**
- Enables users to **add, edit, delete, and fetch comments**.
- Stores **comments separately** from blog posts.
- Fetches blog details from the **Blog Service**.

### 4. **API Gateway**
- **Single entry point** for all API requests.
- Routes requests to appropriate microservices.
- Handles **authentication, logging, and rate limiting**.

## Technologies Used
- **Spring Boot** (Microservices)
- **Spring Cloud Gateway** (API Gateway)
- **Spring Security & JWT** (Authentication)
- **PostgreSQL** (Database for all services)
- **OpenFeign** (Service-to-service communication)
- **Eureka Server** (Service Discovery)
- **Docker & Docker Compose** (Containerization)

## Database Schema
Each microservice has its own PostgreSQL database:

### **User Service (users table)**
| id | username | email | password | role  |
|----|---------|-------|----------|------|

### **Blog Service (blogs table)**
| id | title | content | author_id | created_at | updated_at |
|----|-------|---------|-----------|------------|------------|

### **Comment Service (comments table)**
| id | blog_id | user_id | content | created_at |
|----|--------|--------|---------|------------|

## API Endpoints

### **User Service** (`/api/users`)
| Method | Endpoint          | Description              |
|--------|-----------------|--------------------------|
| POST   | /register       | Register a new user     |
| POST   | /login          | Authenticate user       |
| GET    | /profile/{id}   | Get user profile        |

### **Blog Service** (`/api/blogs`)
| Method | Endpoint              | Description                         |
|--------|----------------------|-------------------------------------|
| POST   | /                     | Create a new blog post             |
| GET    | /                     | Get all blog posts                 |
| GET    | /{id}                 | Get a blog post by ID              |
| PUT    | /{id}                 | Update a blog post                 |
| DELETE | /{id}                 | Delete a blog post                 |

### **Comment Service** (`/api/comments`)
| Method | Endpoint              | Description                         |
|--------|----------------------|-------------------------------------|
| POST   | /blog/{blogId}        | Add a comment to a blog            |
| GET    | /blog/{blogId}        | Get all comments for a blog post   |
| DELETE | /{id}                 | Delete a comment                   |

## How to Run Locally
### **Prerequisites**
- Install **Java 17+**
- Install **Docker & Docker Compose**
- Install **PostgreSQL**

### **Steps to Run**
1. Clone the repository:
   ```sh
   git clone https://github.com/glen654/blog-platform.git
   cd blog-platform
   ```
2. Start the services using Docker Compose:
   ```sh
   docker-compose up --build
   ```
3. The API Gateway will be available at:
   ```sh
   http://localhost:8080/
   ```
4. Access individual services via API Gateway:
    - User Service: `http://localhost:8080/api/users`
    - Blog Service: `http://localhost:8080/api/blogs`
    - Comment Service: `http://localhost:8080/api/comments`

## Future Improvements
- Implement **Kafka or RabbitMQ** for event-driven communication.
- Add **GraphQL API** for efficient querying.
- Implement **Unit and Integration Tests**.



