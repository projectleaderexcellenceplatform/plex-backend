package com.plex.plexbackend.service;

import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.domain.ProjectList;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest(properties = {
    "command.line.runner.enabled=false"})
@Transactional
public class ProjectListServiceTest {

  @Autowired
  private ProjectListService projectListService;


  @Test
  void checkIfLatestProjectListIsReturned() {
    //Arrange
    ProjectList projectListAssert = new ProjectList();
    Set<Project> projectSet = new HashSet<>();
    Project project = new Project();
    project.setId(3L);
    project.setTitle("Testendetestproject");
    project.setShortDescription("Supergave test");
    projectSet.add(project);
    projectListAssert.setProjects(projectSet);
    projectListAssert.setTitle("Projectlijsttest");

    List<ProjectList> projectListBeforeAdding = projectListService.findAllProjectsList();

    //Act
    projectListService.makeNewProjectList(projectListAssert);
    List<Project> latestProjectList = projectListService.findLatest();
    List<ProjectList> fullProjectList = projectListService.findAllProjectsList();

    //Assert
    Assertions.assertEquals(project.getTitle(), latestProjectList.get(0).getTitle());
    Assertions.assertEquals(project.getId(), latestProjectList.get(0).getId());
    Assertions.assertEquals(project.getShortDescription(), latestProjectList.get(0).getShortDescription());
    Assertions.assertNotNull(latestProjectList);
    Assertions.assertEquals(projectListBeforeAdding.size()+1, fullProjectList.size());
  }



}
