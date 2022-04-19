package com.plex.plexbackend.rest;

import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.domain.ProjectList;
import com.plex.plexbackend.service.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ProjectService projectService;

  @BeforeEach
  public void setup() {
    List<Project> listOfProjects = new ArrayList<>();
    Project project = new Project();
    project.setId(1L);
    project.setTitle("Testendetestproject");
    project.setShortDescription("Supergave test");
    listOfProjects.add(project);

    given(projectService.findAllProjects()).willReturn(listOfProjects);
    given(projectService.findProjectsById(project.getId().toString())).willReturn(Optional.of(project));

  }

  @Test
  void getProjects() throws Exception {

    MvcResult result = mvc.perform(
            get("/api/v1/projects")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0].*", hasSize(5)))
        .andReturn();

    String content = result.getResponse().getContentAsString();
    System.out.println(content);

  }

  @Test
  void getProjectsById() throws Exception {

    MvcResult result = mvc.perform(
            get("/api/v1/projects/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1L))
        .andExpect(jsonPath("$.title").value("Testendetestproject"))
        .andExpect(jsonPath("$.shortDescription").value("Supergave test"))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andReturn();

    String content = result.getResponse().getContentAsString();
    System.out.println(content);
  }
}