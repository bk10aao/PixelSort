# Stage 1: Build the application
FROM openjdk:21-jdk-slim AS build
WORKDIR /app

# Create a Gradle cache directory with proper permissions
RUN mkdir -p /tmp/gradle-cache && chmod -R 777 /tmp/gradle-cache

# Copy Gradle wrapper and configuration files first to cache dependencies
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./
RUN chmod +x gradlew

# Download dependencies (cached unless build.gradle.kts or settings.gradle.kts changes)
RUN ./gradlew dependencies --no-daemon -g /tmp/gradle-cache

# Copy the rest of the source code and build
COPY . .
RUN ./gradlew clean build --no-daemon -g /tmp/gradle-cache

# Stage 2: Create runtime image
FROM openjdk:21-jdk-slim AS runtime
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
CMD ["java", "-Xmx4096m", "-jar", "app.jar"]