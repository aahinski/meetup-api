package com.ahinski.meetupapi.controller;

import com.ahinski.meetupapi.model.Meetup;
import com.ahinski.meetupapi.service.MeetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class MeetupController {

    @Autowired
    private MeetupService meetupService;

    @GetMapping("/")
    public String redirectToMeetupList(Model model) {
        return "redirect:/meetups";
    }

    @GetMapping("/meetups")
    public String meetupList(Model model) {
        List<Meetup> meetupList = this.meetupService.getMeetupList();
        model.addAttribute("meetupList", meetupList);
        return "meetups";
    }

    @GetMapping("/meetups/delete/{id}")
    public String deleteMeetup(@PathVariable(value="id") Long id, Model model) {
        Meetup meetup = this.meetupService.getMeetupById(id);
        this.meetupService.deleteMeetup(meetup);
        return "redirect:/meetups";
    }

    @GetMapping("/meetups/update/{id}")
    public String updateMeetupGet(@PathVariable(value="id") Long id, Model model) {
        Meetup meetup = this.meetupService.getMeetupById(id);
        model.addAttribute("meetup", meetup);
        return "meetup-update";
    }

    @PostMapping("/meetups/update/{id}")
    public String updateMeetupPost(Model model,
                            @RequestParam Long id,
                            @RequestParam String theme,
                            @RequestParam String description,
                            @RequestParam String timestamp, @RequestParam String organizer,
                            @RequestParam String place)
    {
        Meetup meetup = new Meetup();

        meetup.setId(id);
        meetup.setTheme(theme);
        meetup.setDescription(description);
        meetup.setTimestamp(Timestamp.valueOf(timestamp.replace("T", " ") + ":00"));
        meetup.setOrganizer(organizer);
        meetup.setPlace(place);

        this.meetupService.updateMeetup(meetup);
        return "redirect:/meetups";
    }

    @GetMapping("/meetups/add")
    public String addMeetupGet(Model model) {
        return "meetup-add";
    }

    @PostMapping("/meetups/add")
    public String addMeetupPost(Model model,
                            @RequestParam String theme,
                            @RequestParam String description,
                            @RequestParam String timestamp,
                            @RequestParam String organizer,
                            @RequestParam String place)
    {
        Meetup meetup = new Meetup();

        meetup.setTheme(theme);
        meetup.setDescription(description);
        meetup.setTimestamp(Timestamp.valueOf(timestamp.replace("T", " ") + ":00"));
        meetup.setOrganizer(organizer);
        meetup.setPlace(place);

        this.meetupService.addMeetup(meetup);
        return "redirect:/meetups";
    }

    @GetMapping("/meetups/{id}")
    public String meetupDetails(@PathVariable(value="id") Long id, Model model) {
        Meetup meetup = this.meetupService.getMeetupById(id);
        model.addAttribute("meetup", meetup);
        return "meetup-details";
    }

}
