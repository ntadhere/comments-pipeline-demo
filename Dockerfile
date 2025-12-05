# Use a Java 17 runtime
FROM eclipse-temurin:17-jdk

# Create a working directory inside the container
WORKDIR /app

# The JAR will be built by Maven into the target folder
ARG JAR_FILE=target/*.jar

# Copy the JAR produced by Maven into the image
COPY ${JAR_FILE} app.jar

# Spring Boot listens on 8080 by default
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
