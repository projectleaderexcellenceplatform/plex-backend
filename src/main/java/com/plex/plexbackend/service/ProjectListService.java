package com.plex.plexbackend.service;

import com.plex.plexbackend.domain.ProjectList;
import com.plex.plexbackend.repository.ProjectListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectListService {

  @Autowired
  private ProjectListRepository projectListRepository;

  public List<ProjectList> findAllProjectsList() {
    return projectListRepository.findAll();
  }

  public Optional<ProjectList> findProjectListById(String id){
    return projectListRepository.findById(Long.parseLong(id));
  }

  public void makeNewProjectList(ProjectList projectList) {
    projectListRepository.save(projectList);
  }

}
