# Use Maven image to build the project
FROM maven:3.8.8-eclipse-temurin-17 AS builder

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the project
RUN mvn clean package

# Use JDK image for runtime
FROM eclipse-temurin:17-jre

# Set the working directory
WORKDIR /app

# Copy the built JAR from the Maven builder
COPY --from=builder /app/target/BDD_FrameWork-0.0.1-SNAPSHOT.jar app.jar

# Expose any necessary ports
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
