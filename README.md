# CarsWebJava

A Spring Boot web application that allows users to search for cars based on various criteria (length, weight, velocity, color) and download the results in XML format. The application is built using Java 21, Spring Boot, H2 database, and Thymeleaf for the frontend.

## Features
- **Search for cars** based on criteria (length, weight, velocity, color).
- **Download results** in XML format.
- Built with **Java 21** and **Spring Boot**.
- Uses **H2** in-memory database for storage.
- **Thymeleaf** for rendering HTML templates.

## Prerequisites

- **Java 21** or higher
- **Gradle** (to build the project)
- **Docker** (optional, for running the application in a container)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/kukuhsain/CarsWebJava.git
cd CarsWebJava
```

### 2. Build the Project

You can build the project using Gradle:

```bash
./gradlew build
```

This will generate a `WAR` file in the `build/libs` directory.

### 3. Run the Application Locally

To run the application locally, you can use the following command:

```bash
./gradlew bootRun
```

This will start the application on `http://localhost:8080`. You can access the app through this URL and use the search functionality.

## Database

The project uses **H2 Database** as an in-memory database. The data is populated in the database on startup. You can change the database configuration in `application.properties` if needed.
