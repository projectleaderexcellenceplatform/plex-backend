package com.plex.plexbackend.rest;

import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class ProjectController {

  @Autowired
  private ProjectRepository projectRepository;



}
