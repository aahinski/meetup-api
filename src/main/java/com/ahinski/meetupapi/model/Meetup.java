package com.ahinski.meetupapi.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "meetups")
@Data
public class Meetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "theme")
    String theme;

    @Column(name = "description")
    String description;

    @Column(name = "timestamp")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    Timestamp timestamp;

    @Column(name = "place")
    String place;

}
