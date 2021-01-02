FROM java:8

ADD target/CourseApiData-0.0.1-SNAPSHOT.jar CourseApiData-0.0.1-SNAPSHOT.jar
EXPOSE 8089

ENTRYPOINT ["java", "-jar", "CourseApiData-0.0.1-SNAPSHOT.jar"]
