package com.plex.plexbackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
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


  @ManyToMany
  private Set<Category> categories;

//  @ManyToMany
//  private Set<Project> projects;

}
