package com.plex.plexbackend.service;

import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.domain.ProjectList;
import com.plex.plexbackend.repository.ProjectListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

  public List<Project> findLatest(){
    return new ArrayList<>(projectListRepository.findAll()
        .stream()
        .max(Comparator.comparing(ProjectList::getId))
        .map(ProjectList::getProjects)
        .orElse(Collections.emptySet()));
  }

}
