package com.researchpapermgmt.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.researchpapermgmt.models.Conference;
import com.researchpapermgmt.repositories.ConferenceRepository;
import com.researchpapermgmt.services.ConferenceService;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;

    ConferenceServiceImpl(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public Conference createConference(Conference conference) {
        return this.conferenceRepository.save(conference);
    }
}
