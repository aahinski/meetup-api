package com.ahinski.meetupapi.controller;

import com.ahinski.meetupapi.model.Meetup;
import com.ahinski.meetupapi.service.MeetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class MeetupController {

    private MeetupService meetupService;

    @Autowired
    public void setMeetupService(MeetupService meetupService) {
        this.meetupService = meetupService;
    }

    @GetMapping("/meetups")
    public String meetupList(Model model) {
        List<Meetup> meetupList = this.meetupService.getMeetupList();
        model.addAttribute("meetupList", meetupList);
        return "meetups";
    }

    @DeleteMapping("/meetups/delete/{id}")
    public String deleteMeetup(@PathVariable(value="id") Long id, Model model) {
        Meetup meetup = this.meetupService.getMeetupById(id);
        this.meetupService.deleteMeetup(meetup);
        return "redirect:/meetups";
    }

    @GetMapping("/meetups/update/{id}")
    public String updateMeetup(@PathVariable(value="id") Long id, Model model) {
        Meetup meetup = this.meetupService.getMeetupById(id);
        model.addAttribute("meetup", meetup);
        return "update-meetup";
    }

    @PostMapping("/meetups/update")
    public String updateMeetup(@ModelAttribute Meetup meetup) {
        this.meetupService.addMeetup(meetup);
        return "redirect:/meetups";
    }

    @GetMapping("/meetups/add")
    public String addMeetup(Model model) {
        return "add-meetup";
    }

    @PostMapping("/meetups/add")
    public String addMeetup(Model model,
                            @RequestParam String theme,
                            @RequestParam String description,
                            @RequestParam String timestamp,
                            @RequestParam String place)
    {
        Meetup meetup = new Meetup();
        System.out.println(timestamp);
        System.out.println(timestamp.replace("T", "") + ":00");
        meetup.setTheme(theme);
        meetup.setDescription(description);
        meetup.setTimestamp(Timestamp.valueOf(timestamp.replace("T", " ") + ":00"));
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
