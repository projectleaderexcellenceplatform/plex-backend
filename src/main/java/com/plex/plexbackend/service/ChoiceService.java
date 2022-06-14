package com.plex.plexbackend.service;

import com.plex.plexbackend.domain.Choice;
import com.plex.plexbackend.domain.ProjectList;
import com.plex.plexbackend.repository.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceService {

  @Autowired
  ChoiceRepository choiceRepository;

  public List<Choice> findAllStudents() {
    return choiceRepository.findAll();
  }

  public List<Choice> findAllStudentsFromProjectlist(String id){
      return choiceRepository.getAllByProjectList(id);
  }

  public void addStudentChoice(Choice choice) {
      long I = choiceRepository.countChoicesByProjectAndAndProjectList(choice.getProject(), choice.getProjectList());
      if (I >0 ){
        List<Choice> Keuzen = choiceRepository.getAllByProjectAndProjectList(choice.getProject(), choice.getProjectList());
        for (var keuze: Keuzen) {
          choiceRepository.deleteById(keuze.getId());
        }
      }
      choiceRepository.save(choice);

  }
}



