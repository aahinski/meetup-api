package com.ahinski.meetupapi.dao;

import com.ahinski.meetupapi.model.Meetup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MeetupDAOImpl implements MeetupDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addMeetup(Meetup meetup) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(meetup);
    }

    @Override
    public void updateMeetup(Meetup meetup) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(meetup);
    }

    @Override
    public void deleteMeetup(Meetup meetup) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(meetup);
    }

    @Override
    public Meetup getMeetupById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Meetup meetup = session.get(Meetup.class, id);
        return meetup;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Meetup> getMeetupList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Meetup> meetupList = session.createQuery("FROM Meetup").list();
        if (meetupList == null) {
            return (new ArrayList<Meetup>());
        } else {
            return meetupList;
        }
    }

}
