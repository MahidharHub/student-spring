FROM openjdk:8u131-jre-alpine

RUN mkdir -v /app

ADD  target/springdemo-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/springdemo-0.0.1-SNAPSHOT.jar"]
