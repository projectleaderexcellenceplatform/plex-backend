package com.plex.plexbackend;

import com.plex.plexbackend.domain.Category;
import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.repository.ProjectRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataSeederApiDex implements CommandLineRunner {

  @Autowired
  private ProjectRepository projectRepository;

  @Override
  public void run(String... args) throws IOException, InterruptedException {
    AddingDatabaseFromDexApi();
  }

  public void AddingDatabaseFromDexApi() throws IOException, InterruptedException {
    //Projects loading and adding to database
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(
            URI.create("https://api.dex.software/api/project"))
        .GET()
        .build();
    var response = client.send(request, HttpResponse.BodyHandlers.ofString());
    String rawJson = response.body();

    JSONObject root = new JSONObject(rawJson);




    JSONArray projects = root.getJSONArray("results");

    for (int i = 0; i < projects.length(); i++) {
      JSONObject jsonProject = projects.getJSONObject(i);
      Project project = new Project();
      int id = jsonProject.getInt("id");
      String name = jsonProject.getString("name");
      String shortdes = jsonProject.getString("shortDescription");
      JSONObject user = jsonProject.getJSONObject("user");
      String uploader = user.getString("name");

      Set<Category> category = new HashSet<>();
      JSONArray catg = jsonProject.getJSONArray("categories");
      for (int y = 0; y < catg.length(); y++) {
        JSONObject catobject = catg.getJSONObject(y);
        Category category1 = new Category();
        int catId = catobject.getInt("id");
        String catName = catobject.getString("name");
        category1.setId((long) catId);
        category1.setName(catName);
        category.add(category1);
        project.setCategories(category);
      }

      project.setId((long) id);
      project.setTitle(name);
      project.setShortDescription(shortdes);
      project.setUploader(uploader);

      projectRepository.save(project);

    }

  }
}

