# JWT Project

This project is a JWT (JSON Web Token) based authentication system developed using Spring Boot.

## Features

- JWT based authentication and authorization.
- RESTful APIs with Spring Boot Web and Security.
- Database integration with Spring Data JPA and PostgreSQL.
- ModelMapper for object mapping.

## Technologies
* Java 17
* Spring Boot 3.1.5
   * JPA Repository
   * Lombok
   * Model Mapper
* JWT
* PostgreSQL
* Open API

## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 14+
* Maven 3+

To build and run the project, follow these steps:

* Clone the repository: `https://github.com/azizCan10/JwtProject.git`
* Navigate to the project directory
* Open a db in PostgreSQL called jwt
* in application.properties file

```properties
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

jwt.key=YOUR_KEY
```

Put your values instead of these

* Build the project: mvn clean install
* Run the project: mvn spring-boot:run

-> The application will be available at http://localhost:8080

-> Swagger will be available at http://localhost:8080/swagger-ui/index.html

-> You can find collection file in collections folder
