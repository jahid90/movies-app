FROM openjdk:11.0.16-jre-slim

WORKDIR /app

COPY ./target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]