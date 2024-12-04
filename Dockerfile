# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-22-alpine AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download dependencies (caching dependencies)
COPY pom.xml /app/
RUN mvn dependency:go-offline

# Copy the application source code to the container
COPY src /app/src

# Build the application, skipping tests
RUN mvn -D maven.test.skip=true clean package

# Stage 2: Run the application
FROM eclipse-temurin:22-alpine

# Set the working directory for the runtime environment
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/police-backend-0.0.1-SNAPSHOT.jar /app/police-backend.jar

# Expose the port Spring Boot will run on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "/app/police-backend.jar"]
