package com.plex.plexbackend.rest;

import com.plex.plexbackend.domain.Choice;
import com.plex.plexbackend.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class ChoiceController {

  @Autowired
  private ChoiceService choiceService;

  @CrossOrigin
  @GetMapping("/student")
  public List<Choice> getStudents(){
    return choiceService.findAllStudents();
  }

  @CrossOrigin
  @GetMapping("/ChoicesForProjectList/{id}")
  public List<Choice> GetChoicesByProjectList(@PathVariable("id") String id){
    return choiceService.findAllStudentsFromProjectlist(id);
  }


  @CrossOrigin
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path="/student/choice", consumes = {"application/json"})
  public void saveStudentChoice(@RequestBody Choice choice) {
    choiceService.addStudentChoice(choice);
  }
}