FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/charging-station-project-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/app.jar"]