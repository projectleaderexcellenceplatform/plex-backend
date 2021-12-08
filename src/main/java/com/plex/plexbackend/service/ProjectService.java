package com.plex.plexbackend.service;

import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  public List<Project> findAllProjects(){
    return projectRepository.findAll();
  }

  public Optional<Project> findProjectsById(String id){
    return projectRepository.findById(Long.parseLong(id));
  }
}
