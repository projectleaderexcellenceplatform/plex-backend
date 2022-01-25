package com.plex.plexbackend;

import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.domain.ProjectList;
import com.plex.plexbackend.service.ProjectListService;
import com.plex.plexbackend.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(properties = {
    "command.line.runner.enabled=false"})
class PlexBackendApplicationTests {

  @Autowired
  ProjectService projectService;

  @Autowired
  ProjectListService projectListService;

  @Test
  void contextLoads() {
    List<Project> list = projectService.findAllProjects();

    List<ProjectList> projectList = projectListService.findAllProjectsList();

  }


}
