package com.plex.plexbackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

  @Id
  private Long id;
  private String name;

  @ManyToMany
  private Set<Project> projects;

}
