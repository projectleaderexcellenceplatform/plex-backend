package com.plex.plexbackend.rest;

import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.domain.ProjectList;
import com.plex.plexbackend.repository.ProjectRepository;
import com.plex.plexbackend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class ProjectController {

  @Autowired
  private ProjectService projectService;


  @CrossOrigin
  @GetMapping("/projects")
  public List<Project> getProjects(){
    return projectService.findAllProjects();
  }

  @CrossOrigin
  @GetMapping("/projects/{id}")
  public Optional<Project> getProjectById(@PathVariable("id") String id){
    return projectService.findProjectsById(id);
  }



}
