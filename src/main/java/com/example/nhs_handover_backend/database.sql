-- create table task (
--         id SERIAL PRIMARY KEY,
--         patientName varchar(128) NOT NULL,
--         MRNNumber varchar(128) NOT NULL,
--         Priority varchar(128) NOT NULL,
--         taskType varchar(128) NOT NULL,
--         seniority varchar(128) NOT NULL,
--         covidStatus varchar(128) NOT NULL,
--         schedule varchar(128),
--         additionalNotes varchar(2048)
-- );
--
-- create table followuptask(
--                              id SERIAL PRIMARY KEY,
--                              Priority varchar(128) NOT NULL,
--                              taskType varchar(128) NOT NULL,
--                              seniority varchar(128) NOT NULL,
--                              covidStatus varchar(128) NOT NULL,
--                              schedule varchar(128),
--                              additionalNotes varchar(2048)
-- );
--
-- create table doctor (
--                         id SERIAL PRIMARY KEY,
--                         name varchar(128) NOT NULL,
--                         password varchar(128) NOT NULL,
--                         role varchar(128) NOT NULL
-- );
--
--
-- create table doctoroftask (
--                               id serial primary key,
--                               taskid int NOT NULL,
--                               doctorid int NOT NULL
-- );
--
-- create table taskoffollowuptask(
--                                    id serial primary key,
--                                    taskid int NOT NULL,
--                                    followuptask int NOT NULL
-- )
--
-- create table followuptask(
--                              id SERIAL PRIMARY KEY,
--                              Priority varchar(128) NOT NULL,
--                              taskType varchar(128) NOT NULL,
--                              seniority varchar(128) NOT NULL,
--                              covidStatus varchar(128) NOT NULL,
--                              schedule varchar(128),
--                              additionalNotes varchar(2048)
-- );
--
-- create table doctor (
--                         id SERIAL PRIMARY KEY,
--                         name varchar(128) NOT NULL,
--                         password varchar(128) NOT NULL,
--                         role varchar(128) NOT NULL
-- );
--
--
-- create table doctoroftask (
--                               id serial primary key,
--                               taskid int NOT NULL,
--                               doctorid int NOT NULL
-- );
--
-- create table taskoffollowuptask(
--                                    id serial primary key,
--                                    taskid int NOT NULL,
--                                    followuptask int NOT NULL
-- )

create table personList (
                            id SERIAL PRIMARY KEY,
                            name varchar(128) NOT NULL,
                            DOB varchar(128) NOT NULL,
                            sex varchar(128) NOT NULL
);

create table hospitalPersonList(
                                   id SERIAL PRIMARY KEY,
                                   name varchar(128) NOT NULL,
                                   DOB varchar(128) NOT NULL,
                                   sex varchar(128) NOT NULL,
                                   email varchar(128) NOT NULL,
                                   numPager varchar(128) NOT NULL
);

create table jrDoctorList(
                             id SERIAL PRIMARY KEY,
                             name varchar(128) NOT NULL,
                             DOB varchar(128) NOT NULL,
                             sex varchar(128) NOT NULL,
                             email varchar(128) NOT NULL,
                             numPager varchar(128) NOT NULL
);

create table patientList(
                            id SERIAL PRIMARY KEY,
                            name varchar(128) NOT NULL,
                            DOB varchar(128) NOT NULL,
                            patientLocation varchar(128) NOT NULL,
                            numMRN varchar(128) NOT NULL
);


create table currTaskList (
                              id SERIAL PRIMARY KEY,
                              patientName varchar(128) NOT NULL,
                              MRNNumber varchar(128) NOT NULL,
                              Priority varchar(128) NOT NULL,
                              taskType varchar(128) NOT NULL,
                              seniority varchar(128) NOT NULL,
                              covidStatus varchar(128) NOT NULL,
                              schedule varchar(128),
                              additionalNotes varchar(2048)
);

create table doneTaskList (
                              id SERIAL PRIMARY KEY,
                              patientName varchar(128) NOT NULL,
                              MRNNumber varchar(128) NOT NULL,
                              Priority varchar(128) NOT NULL,
                              taskType varchar(128) NOT NULL,
                              seniority varchar(128) NOT NULL,
                              covidStatus varchar(128) NOT NULL,
                              schedule varchar(128),
                              additionalNotes varchar(2048)
);