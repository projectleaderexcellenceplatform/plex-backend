package com.plex.plexbackend.service;

import com.plex.plexbackend.domain.Category;
import com.plex.plexbackend.repository.CategoryRepository;
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
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public void loadCategoryFromDex() throws IOException, InterruptedException {
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(
            URI.create("https://api.dex.software/api/category"))
        .GET()
        .build();
    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      saveCategoryToDb(response.body());
    }
    catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void saveCategoryToDb(String json) {
    Category category = new Category();
    JSONArray cat = new JSONArray(json);
    for (int i = 0; i < cat.length(); i++) {
      JSONObject catObject = cat.getJSONObject(i);
      int catId = catObject.getInt("id");
      String name = catObject.getString("name");
      category.setId((long) catId);
      category.setName(name);
      categoryRepository.save(category);
    }
  }

  public List<Category> findAllCategorys(){
    return categoryRepository.findAll();
  }

  public Optional<Category> findCategoryById(String id) {
    return categoryRepository.findById(Long.valueOf(id));
  }
}
