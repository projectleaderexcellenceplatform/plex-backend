package com.plex.plexbackend.service;

import com.plex.plexbackend.domain.Student;
import com.plex.plexbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

  @Autowired
  StudentRepository studentRepository;

  public List<Student> findAllStudents() {
    return null;
  }

  public void addStudentChoice(Student student) {
    studentRepository.save(student);
  }
}
