package com.ahinski.meetupapi.dao;

import com.ahinski.meetupapi.model.Meetup;

import java.util.List;

public interface MeetupDAO {

    void addMeetup(Meetup meetup);
    void updateMeetup(Meetup meetup);
    void deleteMeetup(Meetup meetup);
    Meetup getMeetupById(Long id);
    public List<Meetup> getMeetupList();

}
