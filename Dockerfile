FROM openjdk:21-jdk-slim AS build
WORKDIR /app

RUN mkdir -p /tmp/gradle-cache && chmod -R 777 /tmp/gradle-cache

COPY gradlew gradlew
COPY gradle gradle
COPY . .

RUN chmod +x gradlew
RUN ./gradlew clean build --no-daemon --refresh-dependencies -g /tmp/gradle-cache

FROM openjdk:21-jdk-slim AS runtime
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
