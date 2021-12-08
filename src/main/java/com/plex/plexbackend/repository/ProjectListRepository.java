package com.plex.plexbackend.repository;

import com.plex.plexbackend.domain.ProjectList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface ProjectListRepository extends JpaRepository<ProjectList, Long> {

}
