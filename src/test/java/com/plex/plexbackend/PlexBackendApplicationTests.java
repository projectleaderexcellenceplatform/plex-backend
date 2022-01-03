package com.plex.plexbackend;

import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(properties = {
    "command.line.runner.enabled=false"})
class PlexBackendApplicationTests {

  @Autowired
  ProjectService projectService;

  @Test
  void contextLoads() {
    List<Project> list = projectService.findAllProjects();
  }

}
