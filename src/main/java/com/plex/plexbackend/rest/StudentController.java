package com.plex.plexbackend.rest;

import com.plex.plexbackend.domain.Student;
import com.plex.plexbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @CrossOrigin
  @GetMapping("/student")
  public List<Student> getStudents(){
    return studentService.findAllStudents();
  }

  @CrossOrigin
  @PostMapping(path="/student/choice", consumes = {"application/json"})
  public void saveStudentChoice(@RequestBody Student student) {
    studentService.addStudentChoice(student);
  }
}