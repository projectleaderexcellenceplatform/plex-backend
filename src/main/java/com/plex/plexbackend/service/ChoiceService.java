package com.plex.plexbackend.service;

import com.plex.plexbackend.domain.Choices;

import com.plex.plexbackend.repository.ChoicesRepository;
import com.plex.plexbackend.repository.ProjectListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChoiceService {

    @Autowired
    private ChoicesRepository ChoicesRepository;
    public void makeNewChoice(Choices choices) {
        ChoicesRepository.save(choices);
    }

}
