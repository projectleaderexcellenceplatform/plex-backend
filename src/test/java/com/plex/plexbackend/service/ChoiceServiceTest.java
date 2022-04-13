package com.plex.plexbackend.service;

import com.plex.plexbackend.domain.Choice;
import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
    "command.line.runner.enabled=false"})
@Transactional
class ChoiceServiceTest {

  @Autowired
  private ChoiceService choiceService;

  @Test
  void addStudentChoice() {
    //Arrange
    Student student = new Student();
    student.setStudentId(1L);
    student.setName("Testpiet");

    Project project = new Project();
    project.setId(1L);
    project.setTitle("Testendetestproject");
    project.setShortDescription("Supergave test");

    Choice choice = new Choice();
    choice.setId(2L);
    choice.setChoice(1L);
    choice.setStudent(student);
    choice.setProject(project);

    List<Choice> choiceListBeforeAdding = choiceService.findAllStudents();

    //Act
    choiceService.addStudentChoice(choice);
    List<Choice> fullChoiceList = choiceService.findAllStudents();

    //Assert
    Assertions.assertEquals(choiceListBeforeAdding.size()+1, fullChoiceList.size());
  }
}