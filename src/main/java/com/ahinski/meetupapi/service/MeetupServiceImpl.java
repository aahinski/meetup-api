package com.ahinski.meetupapi.service;

import com.ahinski.meetupapi.dao.MeetupDAO;
import com.ahinski.meetupapi.model.Meetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeetupServiceImpl implements MeetupService {

    private MeetupDAO meetupDAO;

    @Autowired
    public void setMeetupDAO(MeetupDAO meetupDAO) {
        this.meetupDAO = meetupDAO;
    }

    @Override
    @Transactional
    public void addMeetup(Meetup meetup) {
        this.meetupDAO.addMeetup(meetup);
    }

    @Override
    @Transactional
    public void updateMeetup(Meetup meetup) {
        this.meetupDAO.updateMeetup(meetup);
    }

    @Override
    @Transactional
    public void deleteMeetup(Meetup meetup) {
        this.meetupDAO.deleteMeetup(meetup);
    }

    @Override
    @Transactional
    public Meetup getMeetupById(Long id) {
        Meetup meetup = this.meetupDAO.getMeetupById(id);
        return meetup;
    }

    @Override
    @Transactional
    public List<Meetup> getMeetupList() {
        List<Meetup> meetupList = this.meetupDAO.getMeetupList();
        return meetupList;
    }

}
