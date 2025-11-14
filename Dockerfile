# Dockerfile for the Scientific Calculator

# --- Build Stage ---
# Use a Maven image to build the application JAR file
FROM maven:3.9-eclipse-temurin-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

# --- Run Stage ---
# Use the standard, official openjdk 11 JRE image.
FROM openjdk:11.0.11-jre-slim
WORKDIR /app

# Copy the JAR file from the 'build' stage
# The 'jar-with-dependencies' name comes from your pom.xml
COPY --from=build /app/target/scientific-calculator-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# Command to run the application when the container starts
CMD ["java", "-jar", "app.jar"]
