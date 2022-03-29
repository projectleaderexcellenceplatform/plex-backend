package com.plex.plexbackend.repository;

import com.plex.plexbackend.domain.Choices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoicesRepository extends JpaRepository<Choices, Long> {

}
