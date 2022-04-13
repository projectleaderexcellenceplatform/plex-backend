package com.plex.plexbackend.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plex.plexbackend.domain.Choice;
import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.domain.Student;
import com.plex.plexbackend.service.ChoiceService;
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

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChoiceController.class)
class ChoiceControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ChoiceService choiceService;

  @Test
  public void saveStudentChoice() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();

    Map<String, Object> body = new HashMap<>();
    body.put("student",Map.of("studentId",1));
    body.put("project",Map.of("id",1));
    body.put("choice", "1");

    mvc.perform(MockMvcRequestBuilders
        .post("/api/v1/student/choice")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(body)))
        .andExpect(MockMvcResultMatchers.status().isCreated());
  }
}