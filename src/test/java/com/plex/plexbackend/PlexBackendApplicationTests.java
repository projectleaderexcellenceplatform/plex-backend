package com.plex.plexbackend;

import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.domain.ProjectList;
import com.plex.plexbackend.service.ProjectListService;
import com.plex.plexbackend.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest(properties = {
    "command.line.runner.enabled=false"})
@Transactional
class PlexBackendApplicationTests {

  @Autowired
  ProjectService projectService;

  @Autowired
  ProjectListService projectListService;

  @Test
  void contextLoads() {
    List<Project> list = projectService.findAllProjects();

    List<ProjectList> allProjectList = projectListService.findAllProjectsList();

    List<Project> latestProjectList = projectListService.findLatest();
    System.out.println("klaar");

  }


}
