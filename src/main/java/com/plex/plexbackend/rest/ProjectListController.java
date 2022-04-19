package com.plex.plexbackend.rest;

import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.domain.ProjectList;
import com.plex.plexbackend.service.ProjectListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class ProjectListController {

  @Autowired
  private ProjectListService projectListService;

  @CrossOrigin
  @GetMapping("/projectlist")
  public List<ProjectList> getProjects() {
    return projectListService.findAllProjectsList();
  }

  @CrossOrigin
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = "/projectlist/add", consumes = { "application/json" })
  public void saveProjectList(@RequestBody ProjectList projectList) {
    projectListService.makeNewProjectList(projectList);
  }

  @CrossOrigin
  @GetMapping("/projectlist/{id}")
  public Optional<ProjectList> getProjectById(@PathVariable("id") String id) {
    return projectListService.findProjectListById(id);
  }

  @CrossOrigin
  @GetMapping("/projectlist/latest")
  public List<Project> getLatestProjectList() {
    return projectListService.findLatest();
  }
}
