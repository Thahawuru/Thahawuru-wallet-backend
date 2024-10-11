# Stage 1: Build the JAR file using Maven (or Gradle if you prefer)
FROM maven:3.9.9-eclipse-temurin-22-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file and the source code into the container
COPY pom.xml .
COPY src ./src

# Run Maven to build the project and create the JAR file
RUN mvn clean package -DskipTests

# Stage 2: Use a minimal Java image to run the application
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory for the application
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar ./app.jar

# Expose the port used by the Spring Boot application
EXPOSE 8082

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
