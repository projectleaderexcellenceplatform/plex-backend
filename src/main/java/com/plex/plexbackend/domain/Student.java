package com.plex.plexbackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

  @Id
  private Long id;
  private Long choice;

  @ManyToOne
  private Project project;

  @ManyToOne
  private ProjectList projectList;

}
