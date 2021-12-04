package com.plex.plexbackend.service;

import com.plex.plexbackend.repository.ProjectListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectListService {

  @Autowired
  private ProjectListRepository projectListRepository;

}
