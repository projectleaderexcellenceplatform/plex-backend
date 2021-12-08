package com.plex.plexbackend.service;

import com.plex.plexbackend.domain.ProjectList;
import com.plex.plexbackend.repository.ProjectListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectListService {

  @Autowired
  private ProjectListRepository projectListRepository;

  public List<ProjectList> findAllProjectsList() {
    return projectListRepository.findAll();
  }

  public ProjectList makeNewProjectList(ProjectList projectList) {
    return projectListRepository.save(projectList);

  }

}
