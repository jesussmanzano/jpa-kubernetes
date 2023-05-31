FROM openjdk:11
EXPOSE 8080
ADD target/springboot-crud-app.jar springboot-crud-app.jar
ENTRYPOINT ["java", "-jar", "springboot-crud-app.jar"]
