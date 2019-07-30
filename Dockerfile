FROM maven:3.5.2-jdk-8 AS builder
WORKDIR /usr/app/
COPY . .
RUN mvn package --projects Spectrolus --also-make

FROM openjdk:8-jre-alpine
WORKDIR /usr/app/
COPY --from=builder /usr/app/Spectrolus/target/Spectrolus-jar-with-dependencies.jar /usr/app/Spectrolus.jar
ENTRYPOINT ["java", "-Xmx512M", "-XX:+UseG1GC", "-XX:+DisableExplicitGC", "-jar", "Spectrolus.jar"]

