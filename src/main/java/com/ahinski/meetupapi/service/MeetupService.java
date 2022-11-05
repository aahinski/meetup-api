package com.ahinski.meetupapi.service;

import com.ahinski.meetupapi.model.Meetup;

import java.util.List;

public interface MeetupService {

    void addMeetup(Meetup meetup);
    void updateMeetup(Meetup meetup);
    void deleteMeetup(Meetup meetup);
    Meetup getMeetupById(Long id);
    public List<Meetup> getMeetupList();

}
