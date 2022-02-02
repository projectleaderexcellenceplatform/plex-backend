package com.plex.plexbackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.plex.plexbackend.domain.Category;
import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.repository.ProjectRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;


  public void loadProjectFromDex() {
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(
            URI.create("https://api.dex.software/api/project"))
        .GET()
        .build();
    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      saveProjectsToDb(response.body());
    }
    catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void saveProjectsToDb(String json) throws JsonProcessingException {
    JSONObject jsonObject = new JSONObject(json);
    Project project = new Project();
    JSONArray results = jsonObject.getJSONArray("results");

    for (int i = 0; i < results.length(); i++) {
      JSONObject jsonProject = results.getJSONObject(i);
      int id = jsonProject.getInt("id");
      String name = jsonProject.getString("name");
      String shortDes = jsonProject.getString("shortDescription");
      JSONObject user = jsonProject.getJSONObject("user");
      String uploader = user.getString("name");

      Set<Category> categorySet = new HashSet<>();
      JSONArray cat = jsonProject.getJSONArray("categories");
      if (cat != null) {
        for (int y = 0; y < cat.length(); y++) {
          JSONObject catObject = cat.getJSONObject(y);
          Category category1 = new Category();
          int catId = catObject.getInt("id");
          category1.setId((long) catId);
          categorySet.add(category1);
          project.setCategories(categorySet);
        }
        project.setId((long) id);
        project.setTitle(name);
        project.setShortDescription(shortDes);
        project.setUploader(uploader);

        projectRepository.save(project);
      }
    }
  }

  public List<Project> findAllProjects(){
    return projectRepository.findAll();
  }

  public Optional<Project> findProjectsById(String id){
    return projectRepository.findById(Long.parseLong(id));
  }
}
