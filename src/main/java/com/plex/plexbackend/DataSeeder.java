package com.plex.plexbackend;

import com.plex.plexbackend.domain.Category;
import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.repository.CategoryRepository;
import com.plex.plexbackend.repository.ProjectRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.Set;

@ConditionalOnProperty(
    prefix = "command.line.runner",
    value = "enabled",
    havingValue = "true",
    matchIfMissing = true)
@Component
public class DataSeeder implements CommandLineRunner {

  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public void run(String... args) throws IOException, InterruptedException {
    addingProjectsToDb();
    addingCategorysToDb();
  }

  public JSONObject gettingJsonProjectsFromApiDex() throws IOException, InterruptedException {

    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(
            URI.create("https://api.dex.software/api/project"))
        .GET()
        .build();
    var response = client.send(request, HttpResponse.BodyHandlers.ofString());
    String rawJson = response.body();

    return new JSONObject(rawJson);
  }
  public JSONArray gettingJsonCategoriesFromApiDex() throws IOException, InterruptedException {

    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(
            URI.create("https://api.dex.software/api/category"))
        .GET()
        .build();
    var response = client.send(request, HttpResponse.BodyHandlers.ofString());
    String rawJson = response.body();

    return new JSONArray(rawJson);
  }

  private void addingProjectsToDb() throws IOException, InterruptedException {
    JSONObject responseBody = gettingJsonProjectsFromApiDex();
    Project project = new Project();
    JSONArray projects = responseBody.getJSONArray("results");

      //Project
    for (int i = 0; i < projects.length(); i++) {
      JSONObject jsonProject = projects.getJSONObject(i);
      int id = jsonProject.getInt("id");
      String name = jsonProject.getString("name");
      String shortDes = jsonProject.getString("shortDescription");
      JSONObject user = jsonProject.getJSONObject("user");
      String uploader = user.getString("name");

      //Category
      Set<Category> category = new HashSet<>();
      JSONArray cat = jsonProject.getJSONArray("categories");
      if(cat != null) {
        for (int y = 0; y < cat.length(); y++) {
          JSONObject catObject = cat.getJSONObject(y);
          Category category1 = new Category();
          int catId = catObject.getInt("id");
          category1.setId((long) catId);
          category.add(category1);
          project.setCategories(category);
        }

          //Set project
          project.setId((long) id);
          project.setTitle(name);
          project.setShortDescription(shortDes);
          project.setUploader(uploader);

          //Save to DB
          projectRepository.save(project);
      }
    }
  }

  private void addingCategorysToDb() throws IOException, InterruptedException {
    Category category = new Category();
    JSONArray categories = gettingJsonCategoriesFromApiDex();
    for(int i = 0; i < categories.length(); i++){
      JSONObject catObject = categories.getJSONObject(i);
      int id = catObject.getInt("id");
      String name = catObject.getString("name");
      category.setId((long) id);
      category.setName(name);
      categoryRepository.save(category);
    }
  }
}

