package com.plex.plexbackend.service;

import com.plex.plexbackend.domain.Category;
import com.plex.plexbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> findAllCategorys(){
    return categoryRepository.findAll();
  }

  public Optional<Category> findCategoryById(String id) {
    return categoryRepository.findById(Long.valueOf(id));
  }
}
