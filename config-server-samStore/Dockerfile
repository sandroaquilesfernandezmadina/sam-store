FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /workspace

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN apk add --no-cache curl

COPY --from=builder /workspace/target/*.jar app.jar

EXPOSE 8888

ENTRYPOINT ["java", "-jar","app.jar"]