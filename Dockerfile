FROM openjdk:8
ADD target/saisie-service.jar saisie-service.jar
ENTRYPOINT ["java", "-jar", "/saisie-service.jar"]
EXPOSE 8001