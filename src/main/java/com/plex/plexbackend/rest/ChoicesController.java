package com.plex.plexbackend.rest;

import com.plex.plexbackend.domain.Choices;
import com.plex.plexbackend.domain.Project;
import com.plex.plexbackend.domain.ProjectList;
import com.plex.plexbackend.repository.ChoicesRepository;
import com.plex.plexbackend.service.ChoiceService;
import com.plex.plexbackend.service.ProjectListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class ChoicesController {

    @Autowired
    private ChoiceService ChoiceService;

    @CrossOrigin
    @PostMapping(path = "/choices/choices", consumes = { "application/json" })
    public void saveChoices(@RequestBody Choices choices) {
        ChoiceService.makeNewChoice(choices);

        }
}
