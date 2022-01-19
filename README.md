# NHS_Handover_App_Backend

At 8pm the night team of doctors arrives. Many teams in the hospital have already left by 5pm.  Patients often move from ward to ward and don't have continuity of nursing care.  If a medical job needs doing (eg checking and acting on a blood test) this can rely on verbal handover sometimes along a chain of 2 or more junior doctors.  The person doing the job may not understand the importance or what to do if there is an unexpected event.  This can add up to unintended and potential harmful clinical incidents.

We would like an app-based system whereby handover can be efficiently logged and checked off.  The list can be accessed by the night team, with the night registrar ultimately in charge of ensuring everything has been done by the following morning.

This repository constitutes the backend of our app and is linked to the frontend repository NHS_Handover_App_Frontend in order to have a functioning app. 

# Object Oriented Design

Our Object Oriented design structure is based off the key entities in the handover process and how they interact with each other. We made use of inheritance to create a pyramid class structure with increasing specialisation with depth. This project is divided into 8 classes, each corresponding to the object type required for our app. These classes are listed below. 

- Person

Most general object type, takes in 3 inputs (name, DOB, sex) and has 3 getter functions related to it: getName(), getDOB(), getSex(). 

- Patient

Extends person, it allows us to create patient objects for our app. It takes in 5 inputs (name, DOB, sex, location, MRN number) and has 2 getters and 1 setter function related to it: getNumMRN(), getPatientLocation(), setPatientLocation(). 

- HospitalPersonnel

Extends person. It takes in 5 inputs (name, DOB, sex, email, pager number) and has 4 functions related to it: getNumPager(), getEmail(), addPatient(), createTask(). 

- Doctor

Abstract class that extends HospitalPersonnel. It takes in the same inputs as HospitalPersonnel and has 5 functions related to it: getTasks(), getName(), getEmail(), createFollowUpTask(), archiveTask(). 

- Junior Doctor

Extends doctor, and allows us to create a junior doctor object for our app. It takes in the same inputs as HospitalPersonnel, and has 2 functions related to it: takeUpTask() and getTasks(). 

- Consultant

Extends doctor, and allows us to create a consultant object for our app. It takes in the same inputs as HospitalPersonnel, and has 5 functions related to it: getTasks(), getCompletedTasks(), getAllTasks(), getDoctorTasks(), getDoctorTasks(Doctor doc). 

- Task

It allows us to create a new task for our app. It takes in 6 inputs: an object of type Patient, and strings corresponding to seniority level required, notes, history of tasks, task description, and creation time. It has 9 functions related to it: setDoctorOfTask(JuniorDoctor docIn), getDoctorOfTask(), getTime(), getTaskInfo(), getPatient(), getTaskDescript(), getHistory(), getNotes(), getSeniorityRequired(). 

- SingletonDatabase

It corresponds to a database object that creates lists of patients, doctors, and tasks (completed and uncompleted). 

# Tests

Each class has unit tests related to it, testing its functions. 

# Springboot

# SQL Database


