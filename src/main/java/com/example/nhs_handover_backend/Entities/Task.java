package com.example.nhs_handover_backend.Entities;

import javax.persistence.*;

@Entity (name = "Task")
@Table (name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Patient patientObject;
    @ManyToOne
    private JuniorDoctor doctorOfTask;
    private String seniorityRequired;
    private String additionalNotes;
    private String history;
    private String creationTime;
    private String taskDescript;
    private String covidStatus;
    private String duraton;
    // if status is FALSE, task is incomplete
    private Boolean status;


    public Task(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn, String durationIn, String covidStatusIn){
        patientObject=patIn;
        seniorityRequired=seniorIn;
        additionalNotes=notesIn;
        history=historyIn;
        taskDescript = taskDescriptIn;
        creationTime=creationTimeIn;
        status = false;
        covidStatus = covidStatusIn;
        duraton = durationIn;

    }

    public Task() {
        Patient newPatient = new Patient("TBD","TBD","TBD","TBD","TBD");
        patientObject=newPatient;
        seniorityRequired="TBD";
        additionalNotes="TBD";
        history="TBD";
        taskDescript = "TBD";
        creationTime="TBD";
        status = false;
    }

    public void setDoctorOfTask(JuniorDoctor docIn){
        doctorOfTask= docIn;
    }

    public JuniorDoctor getDoctorOfTask(){return doctorOfTask;

    }

    public String getTime(){
        return creationTime;}

    public String[] getTaskInfo() {
        String[] res = {additionalNotes, history};
        return res;
    }

    public Patient getPatient() {
        return patientObject;
    }

    public String getTaskDescript(){
        return taskDescript;
    }

    public String getHistory(){
        return history;
    }

    public String getNotes(){
        return additionalNotes;}

    public String getSeniorityRequired(){
        return seniorityRequired;}

    public Boolean getStatus(){
        return status;
    }

    public void setStatus(Boolean bool){
        status= bool;
    }

    public Long getId(){
        return id;
    }

    public String getCovidStatus() {
        return covidStatus;
    }

    public String getDuraton() {
        return duraton;
    }
}

