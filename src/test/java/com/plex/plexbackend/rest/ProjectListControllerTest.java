package com.plex.plexbackend.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.domain.ProjectList;
import com.plex.plexbackend.rest.ProjectListController;
import com.plex.plexbackend.service.ProjectListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProjectListController.class)
public class ProjectListControllerTest {


  @Autowired
  private MockMvc mvc;

  @MockBean
  private ProjectListService projectListService;

  @BeforeEach
  public void setup(){
    ProjectList projectListAssert = new ProjectList();
    Set<Project> projectSet = new HashSet<>();
    Project project = new Project();
    project.setId(3L);
    project.setTitle("Testendetestproject");
    project.setShortDescription("Supergave test");
    projectSet.add(project);
    projectListAssert.setProjects(projectSet);
    projectListAssert.setTitle("Projectlijsttest");
    projectListAssert.setId(1L);

    List<ProjectList> allProjectLists = Arrays.asList(projectListAssert);
    given(projectListService.findAllProjectsList()).willReturn(allProjectLists);
    given(projectListService.findProjectListById(projectListAssert.getId().toString())).willReturn(
        Optional.of(projectListAssert));
  }

  @Test
  public void getAllProjectlist() throws Exception {

    MvcResult result = mvc.perform(
        get("/api/v1/projectlist")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].*", hasSize(3)))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andReturn();

    String content = result.getResponse().getContentAsString();
    System.out.println(content);
  }

  @Test
  public void getProjectlistById() throws Exception {

    MvcResult result = mvc.perform(
            get("/api/v1/projectlist/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1L))
        .andExpect(jsonPath("$.title").value("Projectlijsttest"))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andReturn();

    String content = result.getResponse().getContentAsString();
    System.out.println(content);
  }

  @Test
  public void saveProjectList() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();


    Map<String, Object> body = new HashMap<>();
    body.put("title", "Projectlijstnaamtest");

    mvc.perform(MockMvcRequestBuilders
            .post("/api/v1/projectlist/add")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(body)))
        .andExpect(MockMvcResultMatchers.status().isCreated());

  }


}
