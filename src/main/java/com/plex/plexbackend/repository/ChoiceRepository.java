package com.plex.plexbackend.repository;

import com.plex.plexbackend.domain.Choice;
import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.domain.ProjectList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {

    Long countChoicesByProjectAndAndProjectList(Project project, ProjectList projectList);

    List <Choice> getAllByProjectAndProjectList(Project project, ProjectList projectList);

    List <Choice> getAllByProjectList(String id);
}
