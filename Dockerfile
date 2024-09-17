# base image
FROM openjdk:21

EXPOSE 8080

COPY target/jenkins-lab.jar app.jar


ENTRYPOINT ["java", "-jar", "/app.jar"]

