package com.plex.plexbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.event.EventListener;

@SpringBootApplication
public class PlexBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(PlexBackendApplication.class, args);
  }

}
