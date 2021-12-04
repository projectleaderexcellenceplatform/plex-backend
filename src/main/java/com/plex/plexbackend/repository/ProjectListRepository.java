package com.plex.plexbackend.repository;

import com.plex.plexbackend.domain.ProjectList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectListRepository extends JpaRepository<ProjectList, Long> {
  }
