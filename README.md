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
8. This could also be automated if we keep the angular source code in student-spring
9. But I chose to have a separate project student-angular


### Running Docker Container and Docker-compose.yml

1. If you are using in Linux,creating and running is more straight forward.
2. In windows there will be some challenges particularly running the student-angular container.
3. In windows port mapping may not work.
4. We may need to access by docker machine default ip 'docker-machine ip default'
5. Front end Docker build : 'docker build -t student-angular:version1 .'
6. Back  end Docker build : 'docker build -t student-spring:version1 .'
7. Important : Please do not forget the dot in the command
8. Runnning Angular : 'docker run -d  -p 4200:4200   b1c966d6272a'
9. Running Spring :   'docker run -d  -p 8080:8080   8015967e4b5e'
10. Numericals are docker image id's
11.'docker stop f8bbad5704ae' will stop the running container (Here the id is of container)
12. You can see all images by running 'docker images'
13. You can see running containers 'docker ps -a'
14. 'docker rm a1e0c0c50034' will remove the container
15. 'docker rmi b1c966d6272a' will remove the image.
16. 'docker rmi -f b1c966d6272a' will remove the image.
17. please use with force command if the earlier one does not work
18. Important : Please note that ImageId's and ContainerId's are different.
19. When you build the Imageid is created and when you run the docker image the containerid is created

### Running  Docker-compose.yml

1. Running docker-compose is much more easy.
2. If the images are already build .Please verify by running the command 'docker images'
3. You should see 'student-angular' and 'student-spring' with Tag id 'Version1' for both of them
4. Now you can run 'docker-compose up' in the root folder
5. This will start both the containers.
6.To stop please use 'docker-compose down'
