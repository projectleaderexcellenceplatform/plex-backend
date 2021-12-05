package com.plex.plexbackend.rest;

import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class ProjectController {

  @Autowired
  private ProjectRepository projectRepository;


  @CrossOrigin
  @GetMapping("/projects")
  public List<Project> getProjects(){
    return projectRepository.findAll();
  }

  @CrossOrigin
  @GetMapping("/projects/{id}")
  public Optional<Project> getProjectById(@PathVariable("id") String id){
    return projectRepository.findById(Long.parseLong(id));
  }



}
