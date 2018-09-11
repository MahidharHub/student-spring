package com.mahidhar.demo;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mahidhar.demo.domain.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIT {


    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Before
    public void before() {

        headers.setAccept(Arrays.asList(MediaType.ALL));
    }

    @Test
    public void retrieveStudent() throws Exception {

        ResponseEntity<Student> response = restTemplate.getForEntity(createPort("/students/1"),
                Student.class);
        assertTrue(response.getBody().getFirstName().equals("Harrison"));
    }

    @Test
    public void retrieveStudentNotFound() throws Exception {

        ResponseEntity<Student> response = restTemplate.getForEntity(createPort("/students/500"),
                Student.class);
        assertTrue(response.getStatusCode().toString().equals("404"));
    }

    @Test
    public void retrieveAllStudents() throws Exception {

       // ResponseEntity<Student[]> response = restTemplate.getForEntity(createPort("/students/"),
         //       Student[].class);

        ResponseEntity<List<Student>> response = restTemplate.exchange(
                createPort("/students/"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Student>>(){});


        List<Student> students = response.getBody();

        assertTrue(students.get(0).getFirstName().equals("Harrison"));
        assertTrue(students.get(3).getEnrolledCourse().equals("SpringBoot"));
        //assertTrue(mockStudents[1].getCity().equals("Frankfurt"));
    }

    @Test
    public void createStudentSuccess() throws Exception {

        Student mockStudent = new Student();
        mockStudent.setFirstName("HelloTest1");
        mockStudent.setLastName("HelloTest2");
        mockStudent.setCity("Berlin");
        mockStudent.setBatch("morning");
        mockStudent.setEnrolledCourse("Kafka");
        mockStudent.setEnrolledDate(new Date());
        mockStudent.setPostcode(50968);

        ResponseEntity<Student> response = restTemplate.postForEntity(createPort("/students/"),
                mockStudent, Student.class);

        assertTrue(response.getStatusCode().toString().equals("201"));
        assertFalse(response.getStatusCode().is4xxClientError());
        assertFalse(response.getStatusCode().is5xxServerError());
    }

    @Test
    public void createStudentValidationErrors() throws Exception {

        Student mockStudent = new Student();
        mockStudent.setFirstName("He");
        mockStudent.setLastName("HelloTest2");
        mockStudent.setCity("Berlin");
        mockStudent.setBatch("morning");
        mockStudent.setEnrolledCourse("Scala");
        mockStudent.setEnrolledDate(new Date());
        mockStudent.setPostcode(50968);

        ResponseEntity<Student> response = restTemplate.postForEntity(createPort("/students/"),
                mockStudent, Student.class);

        assertTrue(response.getStatusCode().toString().equals("400"));

    }

    @Test
    public void deleteStudent() throws Exception {

        ResponseEntity<Student[]> response = restTemplate.getForEntity(createPort("/students/"),
                Student[].class);
        Student[] mockRegistration = response.getBody();
        int registrationsBeforeDeletion = mockRegistration.length;

        restTemplate.delete(createPort("/students/8"));

        ResponseEntity<Student[]> responseAfterDeletion = restTemplate.getForEntity(createPort("/students/"),
                Student[].class);
        Student[] mockRegistrationAfterDeletion = responseAfterDeletion.getBody();
        int registrationsAfterDeletion = mockRegistrationAfterDeletion.length;

        assertTrue((registrationsBeforeDeletion - 1) == registrationsAfterDeletion);

    }


    /**
     * This method creates the dynamic port
     * @param uri
     * @return dynamic port appended to http://localhost
     */

    private String createPort(final String uri) {
        return "http://localhost:" + port + uri;
    }
}

