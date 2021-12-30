package Entities;

import Entities.Patient;

public class Task {
    private Patient patientObject;
    private HospitalPersonnel doctorOfTask;
    private String seniorityRequired;
    private String additionalNotes;
    private String history;
    private String creationTime;
    private String taskDescript;

    public Task(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
        patientObject=patIn;
        seniorityRequired=seniorIn;
        additionalNotes=notesIn;
        history=historyIn;
        taskDescript = taskDescriptIn;
        creationTime=creationTimeIn;
    }

    public void setDoctorOfTask(Doctor docIn){
        doctorOfTask= docIn;
    }

    public HospitalPersonnel getDoctorOfTask(){
        return doctorOfTask;
    }

    public String getTime(){
        return creationTime;
    }

    public String[] getTaskInfo() {
        String[] res = {additionalNotes, history};
        return res;
    }

    public Patient getPatient() {
        return patientObject;
    }

    public Task createFollowUp() {
        return null;
    }


    public String getTaskDescript(){ return taskDescript;}

    public String getSeniorityRequired(){ return seniorityRequired; }
}

