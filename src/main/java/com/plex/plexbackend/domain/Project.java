package com.plex.plexbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Project {

  @Id
  private Long id;
  private String title;
  private String shortDescription;
  private String uploader;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private Set<Category> categories;

  @ManyToMany
  @JsonIgnore
  private Set<ProjectList> projectLists;

}
