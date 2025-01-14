# Use a Gradle image with Java 21 to build the application
FROM gradle:8.4-jdk21 AS build

# Set the working directory for the build process
WORKDIR /app

# Copy Gradle configuration files
COPY build.gradle settings.gradle /app/
COPY gradle /app/gradle/

# Pre-fetch dependencies to leverage Docker caching
RUN gradle build --no-daemon || return 0

# Copy application source code
COPY src /app/src

# Build the Spring Boot application JAR
RUN gradle bootJar --no-daemon

# Use a lightweight Java 21 runtime image for running the app
FROM openjdk:21-jdk-slim

# Set the working directory for the runtime environment
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
