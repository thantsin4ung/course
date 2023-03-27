FROM openjdk:17
EXPOSE 8080
ADD target/course.jar course.jar
ENTRYPOINT ["java","-jar","/course.jar"]