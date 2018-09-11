package com.mahidhar.demo.controller;


import com.mahidhar.demo.domain.Student;
import com.mahidhar.demo.exception.StudentNotFoundException;
import com.mahidhar.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;



    @RequestMapping(value = "/", method = RequestMethod.GET )
    public Iterable<Student> listAllStudents() {

         return studentService.getAllStudents();

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
          studentService.createStudent(student);
        URI location =     ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.getId())
                .toUri();
        return ResponseEntity
                .created(location)
                .build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET )
    public Student getStudentById(@PathVariable(value = "id") long id) {

        Optional<Student> student = studentService.getStudent(id);
        if(! student.isPresent()) throw new StudentNotFoundException("id" + id);

        return student.get();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Student updateStudent(@PathVariable(value = "id") long id, @RequestBody Student student) {
        return studentService.updateStudent(id,student);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable(value = "id") Long id) {
        studentService.deleteStudent(id);
    }


}
