package com.mahidhar.demo.util;

import com.mahidhar.demo.domain.Student;
import com.mahidhar.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StudentCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory
            .getLogger(StudentCommandLineRunner.class);

    @Autowired
    private StudentService studentService;



    @Override
    public void run(String... args) throws Exception {


        studentService.createStudent(new Student("Harrison","Ford","Blockchain","evening","Cologne",new Date(),50968));
        studentService.createStudent(new Student("Mark","Wahlberg","Scala","morning","Frankfurt",new Date(),50968));
        studentService.createStudent(new Student("Mary","Evans","Kafka","evening","Frankfurt",new Date(),50968));
        studentService.createStudent(new Student("Max","Collins","SpringBoot","evening","Berlin",new Date(),50968));
        studentService.createStudent(new Student("Andrew","Morgen","Hibernate","morning","Hamburg",new Date(),50968));
        studentService.createStudent(new Student("Cathy","Norman","Hadoop","evening","Frankfurt",new Date(),50968));
        studentService.createStudent(new Student("Eon","Nord","Python","morning","Hamburg",new Date(),50968));
        studentService.createStudent(new Student("Keivn","Peterson","Java 9","evening","Hamburg",new Date(),50968));
        studentService.createStudent(new Student("Peter","Smith","Angular 6","morning","Berlin",new Date(),50968));
        studentService.createStudent(new Student("Herschell","Gibbs","IONIC","evening","Frankfurt",new Date(),50968));
        studentService.createStudent(new Student("Gary","Kirsten","AWS","evening","Hamburg",new Date(),50968));
        studentService.createStudent(new Student("Mike ","Powell","Google Firebase","morning","Berlin",new Date(),50968));
        studentService.createStudent(new Student("Carl","Lewis","Android","evening","Berlin",new Date(),50968));
        studentService.createStudent(new Student("Michael","Phelps","Docker","evening","Hamburg",new Date(),50968));
        studentService.createStudent(new Student("Brian","Lara","ReactJS","morning","Berlin",new Date(),50968));
        studentService.createStudent(new Student("John","Hagens","Spring Cloud","morning","Munich",new Date(),50968));
        studentService.createStudent(new Student("Martin","Neuman","Microservices","evening","Frankfurt",new Date(),50968));
        studentService.createStudent(new Student("Susan","Sanders","MS Azure","morning","Munich",new Date(),50968));
        studentService.createStudent(new Student("Mark","Bush","Scala","evening","Munich",new Date(),50968));
        studentService.createStudent(new Student("Tom","Cruise","Kafka","evening","Berlin",new Date(),50968));
        studentService.createStudent(new Student("Brad","Pitt","Selenium","morning","Munich",new Date(),50968));
        studentService.createStudent(new Student("Johnny","Depp","SAP Hana","evening","Berlin",new Date(),50968));
        studentService.createStudent(new Student("Tom","Hanks","AWS Lambda","evening","Frankfurt",new Date(),50968));
        studentService.createStudent(new Student("Russel","Crowe","MEAN","evening","Berlin",new Date(),50968));
        studentService.createStudent(new Student("Matt","Damon","Angular 6","morning","Frankfurt",new Date(),50968));
        studentService.createStudent(new Student("Will","Smith","Docker","evening","Frankfurt",new Date(),50968));






    }
}
