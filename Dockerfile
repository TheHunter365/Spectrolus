FROM maven:3.5.2-jdk AS builder
WORKDIR /usr/app/
COPY . /usr/app/
RUN mvn -f /usr/app/pom.xml clean package

FROM openjdk:8-jre-alpine