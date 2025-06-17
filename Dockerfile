FROM adoptopenjdk:12.0.1_12-jdk-openj9-0.14.1

COPY target/dbinitialization-0.0.1-SNAPSHOT.jar dbinitialization-1.jar

EXPOSE 8088

ENTRYPOINT ["java","-jar","/dbinitialization-1.jar"]