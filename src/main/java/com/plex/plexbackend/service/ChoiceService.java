package com.plex.plexbackend.service;

import com.plex.plexbackend.domain.Choice;
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

  public void addStudentChoice(Choice choice) {
    choiceRepository.save(choice);
  }
}
