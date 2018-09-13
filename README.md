# student-spring

## Technologies used in Front-End application (student-angular)
  1. Angular 5
  2. Bootstrap 4
  3. RX JS(client side search)
  4. ngx-Bootstrap(client side pagination)


## Technologies used in Back-End application(student-spring)
   1. Spring Boot
   2. Spring Rest
   3. Spring JPA
   4. H2 DB
   5. Swagger
   6. Docker

## Building the backend application

###  Generating jar file

        1.You should have Java 8 and Maven already installed in the system
        2.Run mvn clean install in the directory of student-spring
        3.springdemo-0.0.1-SNAPSHOT.jar will be created in target folder
        4.java -jar springdemo-0.0.1-SNAPSHOT.jar will start the server in the port 8080
        5.Now you should be able to access the application by http://localhost:8080
        6.If student-angular is running then you could access application by http://localhost:8080

### Integrating backend and frontend application

        1. We could integrate both backend and frontend applications
        2. Important : Please change environment.ts of student-angular URL's from http://localhost:8080/students/ to /students/
        3. Please run 'ng build' in the student-angular root directory.
        4. On successful completion 'dist' folder would be created
        5. Please copy the contents of dist into student-spring resources/static folder
        6. After copying please do a mvn clean install and start the backend application
        7. Now instead of running two applications we could access the entire application from  http://localhost:8080
        8. This could also be automated if we keep the angular source code in student-spring but I chose to have a separate project student-angular


### Running Docker Container and Docker-compose.yml