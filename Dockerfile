FROM openjdk:21-jdk-slim AS build
WORKDIR /app

RUN mkdir -p /tmp/gradle-cache && chmod -R 777 /tmp/gradle-cache

COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./
RUN chmod +x gradlew

RUN ./gradlew dependencies --no-daemon -g /tmp/gradle-cache

COPY . .
RUN ./gradlew clean build --no-daemon -g /tmp/gradle-cache

FROM openjdk:21-jdk-slim AS runtime
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
CMD ["java", "-Xmx4096m", "-jar", "app.jar"]