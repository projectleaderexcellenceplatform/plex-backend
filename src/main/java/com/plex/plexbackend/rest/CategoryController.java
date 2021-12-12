package com.plex.plexbackend.rest;

import com.plex.plexbackend.domain.Category;
import com.plex.plexbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;


  @CrossOrigin
  @GetMapping("/category")
  public List<Category> getCategory(){
    return categoryService.findAllCategorys();
  }

  @CrossOrigin
  @GetMapping("/category/{id}")
  public Optional<Category> getCategoryById(@PathVariable("id") String id){
    return categoryService.findCategoryById(id);
  }
}
