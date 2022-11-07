# Meetup API

### Task

- Meetup entity
  - Theme
  - Description
  - Organizer
  - Time and date
  - Place

- Endpoints
  - Getting the list of all meetups
  - Getting the meetup by id
  - Creating new meetup
  - Updating the meetup's info
  - Deleting the meetup

### Technologies

- To write the API following technologies were used:
  - Java
  - Spring Boot
  - PostgreSQL
  - Hibernate
  - Thymeleaf
  - Tomcat

### How to start the API

To start the API you need to run MeetupApiApplication.java file on the local server 8083(could be changed in application.properties file) with PostgreSQL installed (db server, username, password also could be changed in the file mentioned above). SQL scripts you need to write before starting the app:
- To create the db:
  - CREATE DATABASE "meetup-api"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Belarus.1252'
    LC_CTYPE = 'Russian_Belarus.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

- To create the table:
  - CREATE TABLE IF NOT EXISTS public.meetups
(
id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
theme character varying COLLATE pg_catalog."default",
description character varying COLLATE pg_catalog."default",
"timestamp" timestamp without time zone,
place character varying COLLATE pg_catalog."default",
organizer character varying COLLATE pg_catalog."default",
CONSTRAINT meetups_pkey PRIMARY KEY (id)
)
  
### Some text from me

I'm looking forward to receive some feedback and there are some points where I want to speak up a little bit.
- One of the additional tasks was adding the sorting by some criteria. This could be achieved by extending PagingAndSortingRepository class, but Spring Data was forbidden to use and I decided to not write something new without knowing it on at least decent level.
- Also the frontend is kinda ugly, but I guess it wasn't the main point of making the app. It's readable and I think it's enough for the task.
- Have a nice day, whoever reads it :)