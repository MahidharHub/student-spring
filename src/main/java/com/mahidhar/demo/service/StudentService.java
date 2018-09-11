package com.mahidhar.demo.service;

import com.mahidhar.demo.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Iterable<Student> getAllStudents();

    Optional<Student> getStudent(Long id);

    Student createStudent(Student student);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);



}
