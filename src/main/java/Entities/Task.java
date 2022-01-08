package Entities;

import Entities.Patient;

public class Task {
    SingletonDatabase db = SingletonDatabase.getInstance();

    private Patient patientObject;
    private JuniorDoctor doctorOfTask = null;
    private String seniorityRequired;
    private String additionalNotes;
    private String history;
    private String creationTime;
    private String taskDescript;
    private String urgency;

    public Task(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn, String urgencyIn){
        patientObject=patIn;
        seniorityRequired=seniorIn;
        additionalNotes=notesIn;
        history=historyIn;
        taskDescript = taskDescriptIn;
        creationTime=creationTimeIn;
        urgency = urgencyIn;
    }

    public void setDoctorOfTask(JuniorDoctor docIn){
        doctorOfTask= docIn;
    }

    public JuniorDoctor getDoctorOfTask(){return doctorOfTask;}

    public String getTime(){
        return creationTime;
    }

    public String[] getTaskInfo() {
        String[] res = {additionalNotes, history};
        return res;
    }

    public String getUrgency(){return urgency;}


    public Patient getPatient() {
        return patientObject;
    }

    public String getTaskDescript(){ return taskDescript;}

    public String getHistory(){ return history;}

    public String getNotes(){ return additionalNotes;}

    public String getSeniorityRequired(){ return seniorityRequired; }
}

