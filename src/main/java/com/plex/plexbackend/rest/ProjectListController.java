package com.plex.plexbackend.rest;

import com.plex.plexbackend.domain.ProjectList;
import com.plex.plexbackend.service.ProjectListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

  @PostMapping(path = "/projectlist/add", consumes = {"application/json"})
  public ProjectList saveProjectList(@RequestBody ProjectList projectList) {
  ProjectList des = projectListService.makeNewProjectList(projectList);
  return des;
  }
}
