# Use OpenJDK as the base image for building the application
FROM openjdk:21-jdk-slim as build

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and necessary files into the container
COPY gradle /app/gradle
COPY gradlew /app/gradlew
COPY build.gradle /app/
COPY settings.gradle /app/

# Copy the source code into the container
COPY src /app/src

# Give execute permissions to the gradlew script (necessary for Linux-based images)
RUN chmod +x gradlew

# Build the app using Gradle
RUN ./gradlew build --no-daemon

# Use Tomcat as the base image to deploy the WAR file
FROM tomcat:9.0-jdk21-openjdk-slim

# Copy the WAR file from the build stage to the Tomcat webapps directory
COPY --from=build /app/build/libs/CarsWebJava-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/CarsWebJava.war

# Expose port 8080 for the Tomcat server
EXPOSE 8080

# Run Tomcat
CMD ["catalina.sh", "run"]
