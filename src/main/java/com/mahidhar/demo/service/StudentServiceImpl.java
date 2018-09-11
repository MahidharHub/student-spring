package com.mahidhar.demo.service;

import com.mahidhar.demo.domain.Student;
import com.mahidhar.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;


    @Override
    public Iterable<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Optional<Student> getStudent(Long id) {
         return repository.findById(id);
    }

    @Override
    public Student createStudent(Student student) {
          return repository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        student.setId(id);
        return repository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
