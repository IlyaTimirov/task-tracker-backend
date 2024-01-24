FROM openjdk:17
ADD /target/task-tracker-backend-0.0.1-SNAPSHOT.jar taskTrackerBackend.jar
ENTRYPOINT ["java", "-jar", "taskTrackerBackend.jar"]