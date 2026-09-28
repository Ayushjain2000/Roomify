# 🏨 Roomify — Hotel Booking & Management Backend

Roomify is a **hotel booking and management backend** built with Java and Spring Boot. It provides REST APIs for user authentication, room management, room availability, hotel bookings, and booking management.

The application uses **Spring Security with JWT authentication**, **Spring Data JPA/Hibernate** for persistence, **MySQL** as the database, and **Amazon S3** for room image storage.

---

## 🚀 Features

### 🔐 Authentication & Authorization

- User registration and login
- JWT-based authentication
- Stateless authentication using Spring Security
- Role-based authorization
- Support for `USER` and `ADMIN` roles
- Protected API endpoints

### 🛏️ Room Management

- Add new rooms
- Update room details
- Delete rooms
- Upload room images to Amazon S3
- Retrieve room information
- Retrieve available room types
- Search for available rooms
- Filter room availability based on dates and room type

### 📅 Booking Management

- Book available rooms
- Check room availability before booking
- Generate booking confirmation codes
- Retrieve bookings
- Retrieve bookings using confirmation code
- Cancel bookings
- View booking history

### 🗄️ Data Persistence

- MySQL database
- Spring Data JPA
- Hibernate ORM
- Entity-based data modeling
- Repository-based persistence layer

### ☁️ Cloud Storage

- Amazon S3 integration for room image storage
- Image upload and retrieval through backend APIs

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT | Token-based Authentication |
| Spring Data JPA | Data Access |
| Hibernate | ORM |
| MySQL | Relational Database |
| Amazon S3 | Room Image Storage |
| Maven | Build & Dependency Management |
| Lombok | Boilerplate Reduction |
| JUnit | Testing |

---

## 🏗️ Architecture

Roomify follows a layered backend architecture.

```text
                        ┌────────────────────┐
                        │      Client        │
                        └─────────┬──────────┘
                                  │
                                  │ HTTP / REST
                                  ▼
                        ┌────────────────────┐
                        │    Controllers     │
                        │    REST APIs       │
                        └─────────┬──────────┘
                                  │
                                  ▼
                        ┌────────────────────┐
                        │     Services       │
                        │  Business Logic    │
                        └───────┬─────┬──────┘
                                │     │
                    ┌───────────┘     └────────────┐
                    ▼                              ▼
          ┌────────────────────┐         ┌──────────────────┐
          │ Repositories / JPA │         │    AWS S3        │
          │                    │         │  Room Images     │
          └─────────┬──────────┘         └──────────────────┘
                    │
                    ▼
          ┌────────────────────┐
          │       MySQL        │
          │ Users / Rooms /    │
          │ Bookings           │
          └────────────────────┘

                 ┌─────────────────────┐
                 │  Spring Security    │
                 │        + JWT        │
                 └─────────────────────┘
```

---

## 📂 Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── hotel/
│   │           └── roomify/
│   │               ├── controller/
│   │               ├── dto/
│   │               ├── entity/
│   │               ├── exception/
│   │               ├── repo/
│   │               ├── security/
│   │               ├── service/
│   │               └── utils/
│   │
│   └── resources/
│       └── application.properties
│
└── test/
    └── java/
```

### Layer Responsibilities

**Controller**

Handles HTTP requests and exposes REST endpoints.

**Service**

Contains application and business logic.

**Repository**

Handles database operations using Spring Data JPA.

**Entity**

Represents database entities such as users, rooms, and bookings.

**DTO**

Handles data transfer between API layers.

**Security**

Contains authentication, authorization, JWT filtering, and security configuration.

**Utils**

Contains reusable utility components such as JWT token handling.

**Exception**

Contains application-specific exception handling.

---

## 🔑 Authentication Flow

Roomify uses JWT-based stateless authentication.

```text
User
 │
 │ Login
 ▼
Authentication API
 │
 │ Validate credentials
 ▼
Spring Security
 │
 │ Generate JWT
 ▼
JWT Token
 │
 │ Include token in subsequent requests
 ▼
JWT Authentication Filter
 │
 │ Validate token
 ▼
Protected API
```

Clients should send the JWT token using the `Authorization` header:

```text
Authorization: Bearer <JWT_TOKEN>
```

---

## 🔌 API Endpoints

The main API operations include the following.

### Authentication

| Method | Endpoint | Description |
|---|---|---|
| POST | `/auth/register` | Register a new user |
| POST | `/auth/login` | Authenticate user and obtain JWT |

---

### Rooms

| Method | Endpoint | Description |
|---|---|---|
| GET | `/rooms/all` | Retrieve all rooms |
| GET | `/rooms/types` | Retrieve available room types |
| GET | `/rooms/all-available-rooms` | Retrieve available rooms |
| GET | `/rooms/available-rooms-by-date-and-type` | Search rooms by date and type |
| POST | `/rooms/add` | Add a new room |
| PUT | `/rooms/update/{roomId}` | Update an existing room |
| DELETE | `/rooms/delete/{roomId}` | Delete a room |

Room images are uploaded and stored using Amazon S3.

---

### Bookings

| Method | Endpoint | Description |
|---|---|---|
| POST | `/bookings/book-room/{roomId}/{userId}` | Create a room booking |
| GET | `/bookings/all` | Retrieve all bookings |
| GET | `/bookings/get-by-confirmation-code/{confirmationCode}` | Find booking using confirmation code |
| DELETE | `/bookings/cancel/{bookingId}` | Cancel a booking |

> API paths may require additional request parameters or bodies depending on the controller implementation.

---

## ⚙️ Getting Started

### Prerequisites

Make sure the following are installed:

- Java 21
- Maven
- MySQL
- AWS account with an S3 bucket
- Git

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

---

## 📥 Clone the Repository

```bash
git clone https://github.com/Ayushjain2000/Roomify.git
```

Move into the project:

```bash
cd Roomify
```

---

## 🗄️ Database Configuration

Create a MySQL database for Roomify.

Example:

```sql
CREATE DATABASE roomify;
```

Configure your local database credentials in:

```text
src/main/resources/application.properties
```

### Example configuration

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/roomify
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
```

**Never commit your real database credentials to GitHub.**

---

## ☁️ AWS S3 Configuration

Roomify uses Amazon S3 to store room images.

Configure the following values locally:

```properties
aws.s3.access.key=YOUR_AWS_ACCESS_KEY
aws.s3.secret.key=YOUR_AWS_SECRET_KEY
```

Also configure the required S3 bucket information according to your local environment.

**Never commit AWS access keys or secret keys to GitHub.**

---

## 🔐 JWT Configuration

The JWT signing secret should be supplied through local configuration/environment variables rather than hard-coded in Java source code.

Example:

```properties
jwt.secret=YOUR_BASE64_ENCODED_JWT_SECRET
```

The real value should remain local and should not be committed to the repository.

---

## ▶️ Running the Application

### Using Maven Wrapper

On macOS/Linux:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

### Using Maven

```bash
mvn spring-boot:run
```

The application runs on:

```text
http://localhost:4040
```

---

## 🧪 Running Tests

Run the test suite using:

```bash
./mvnw test
```

or:

```bash
mvn test
```

---

## 📦 Building the Application

Create a production build:

```bash
./mvnw clean package
```

The generated JAR will be available under:

```text
target/
```

The `target/` directory is intentionally excluded from Git.

---

## 🔒 Security Considerations

This project uses JWT-based authentication and Spring Security.

For local development:

- Keep database credentials outside version control.
- Keep AWS credentials outside version control.
- Keep JWT signing secrets outside version control.
- Use environment variables or local configuration for sensitive values.
- Never commit `.env` files containing real credentials.
- Never expose production credentials in source code.

For production deployments, use a dedicated secret-management solution and IAM policies with the minimum required permissions.

---

## 🧩 Key Backend Components

The project demonstrates several backend engineering concepts:

- RESTful API development
- Layered architecture
- Object-oriented design
- Spring Boot application development
- Spring Security
- JWT authentication
- Role-based authorization
- Database persistence using JPA/Hibernate
- MySQL relational data modeling
- Cloud object storage using AWS S3
- Exception handling
- DTO-based API design
- Repository pattern
- Service layer architecture
- Unit testing
- Maven-based dependency management

---

## 📈 Future Improvements

Potential improvements for future versions include:

- [ ] Swagger / OpenAPI API documentation
- [ ] Docker support
- [ ] Docker Compose for local MySQL setup
- [ ] Pagination for room and booking APIs
- [ ] More comprehensive integration tests
- [ ] Global exception handling improvements
- [ ] Improved API validation
- [ ] Booking concurrency controls
- [ ] Centralized application configuration
- [ ] Production-ready secret management
- [ ] CI/CD pipeline
- [ ] Deployment to AWS

---

## 👨‍💻 Author

**Ayush Jain**

Software Development Engineer

- GitHub: [Ayushjain2000](https://github.com/Ayushjain2000)

---

## ⭐ Project

If you find this project useful or interesting, feel free to ⭐ the repository.

**Roomify — Hotel Booking & Management Backend**

Built with ❤️ using Java and Spring Boot.