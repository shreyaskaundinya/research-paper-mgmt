package com.researchpapermgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.researchpapermgmt.models.Conference;
import com.researchpapermgmt.services.ConferenceService;

@Controller
@RequestMapping("/conf/")
public class ConferenceController {

    private ConferenceService conferenceService;

    ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    // TODO : Create conf

    @GetMapping("/create")
    public String GetCreateConfPage() {
        return "conference/create";
    }

    @PostMapping("/create")
    public String PostCreateConfPage(Model model, @RequestParam String name, @RequestParam String start_date,
            @RequestParam String end_date, @RequestParam String location) {

        // model.addAttribute("name", name);
        // model.addAttribute("start_date", start_date);
        // model.addAttribute("end_date", end_date);
        // model.addAttribute("location", location);
        Conference conf = new Conference();
        conf.setName(name);
        conf.setLocation(location);
        conf.setStarting_date(start_date);
        conf.setEnding_date(end_date);

        // conference service : create paper
        conferenceService.createConference(conf);

        return "conference/viewall";
    }

    

    // TODO : Edit conf
    // TODO : Get Conf by id page [specific conf page]
    // TODO : Get all conferences page [page with all conferences]
    // TODO : Search conferences
}
