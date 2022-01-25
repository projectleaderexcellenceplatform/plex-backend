package com.plex.plexbackend.assembly;

import com.plex.plexbackend.domain.Category;
import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.repository.CategoryRepository;
import com.plex.plexbackend.repository.ProjectRepository;
import com.plex.plexbackend.service.CategoryService;
import com.plex.plexbackend.service.ProjectService;
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
  ProjectService projectService;

  @Autowired
  CategoryService categoryService;

  @Override
  public void run(String... args) throws IOException, InterruptedException {
    projectService.loadProjectFromDex();
    categoryService.loadCategoryFromDex();
  }
}

