package com.plex.plexbackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Array;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Choices {

    @Id
    @Column
    private Long StudentId;

    @ElementCollection
    private Set<String> Choices;

}