# Etapa de build com Gradle 8.13 e JDK 21
FROM gradle:8.13-jdk21 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . /home/gradle/project
RUN gradle build --no-daemon

# Etapa de execução com JDK 21
FROM openjdk:21-jdk-slim
VOLUME /tmp
COPY --from=build /home/gradle/project/build/libs/app.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
