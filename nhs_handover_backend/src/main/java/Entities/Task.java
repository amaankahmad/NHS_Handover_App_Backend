package Entities;

import Entities.Patient;

public class Task {
    private Patient patientObject;
    private String seniorityRequired;
    private String additionalNotes;
    private String history;
    private String creationTime;
    private String taskDescription;

    public Task(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
        patientObject=patIn;
        seniorityRequired=seniorIn;
        additionalNotes=notesIn;
        history=historyIn;
        taskDescription = taskDescriptIn;
        creationTime=creationTimeIn;
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
}
