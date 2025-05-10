# Build stage
FROM openjdk:21-jdk-slim AS build

WORKDIR /app

# Create Gradle cache directory
RUN mkdir -p /tmp/gradle-cache && chmod -R 777 /tmp/gradle-cache

# Copy Gradle wrapper and config
COPY gradlew gradlew
COPY gradle gradle

# Copy project files
COPY . .

# Make Gradle wrapper executable
RUN chmod +x gradlew

# Build the application
RUN ./gradlew clean build --no-daemon --refresh-dependencies -g /tmp/gradle-cache

# Runtime stage
FROM openjdk:21-jdk-slim AS runtime

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
