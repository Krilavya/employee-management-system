# Employee Management System

## Overview
This is a Spring Boot REST API project for managing employee records.

## Features
- Create Employee
- Get Employee
- Update Employee
- Delete Employee
- Search Employee By Name
- Pagination
- Sorting
- Validation
- Global Exception Handling
- Swagger Documentation

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradle
- Swagger OpenAPI
- Lombok

## API Endpoints

### Employee APIs

GET /employees

GET /employees/{id}

POST /employees

PUT /employees/{id}

DELETE /employees/{id}

GET /employee/email/{email}

GET /employee/search/{name}

GET /employees/sort/{field}

GET /employees/page

## Run Project

```bash
gradlew bootRun