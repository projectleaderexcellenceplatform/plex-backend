package com.plex.plexbackend;

import com.plex.plexbackend.domain.Category;
import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.repository.ProjectRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class MyRunner implements CommandLineRunner {

  @Autowired
  private ProjectRepository projectRepository;

  @Override
  public void run(String... args) throws Exception {

    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(
            URI.create("https://api.dex.software/api/project"))
        .GET()
        .build();
    var response = client.send(request, HttpResponse.BodyHandlers.ofString());
    String rawJson = response.body();

    JSONObject root = new JSONObject(rawJson);

    JSONArray projects = root.getJSONArray("results");

    for(int i = 0; i < projects.length(); i++){
      JSONObject jsonProject = projects.getJSONObject(i);
      Project project = new Project();
      int id = jsonProject.getInt("id");
      String name = jsonProject.getString("name");
      String shortdes = jsonProject.getString("shortDescription");
//     String categories = jsonProject.getString("categories");

      project.setId((long) id);
      project.setTitle(name);
      project.setShortDescription(shortdes);

      projectRepository.save(project);

    }

  }

}
