package Entities;

import Entities.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task {
    SingletonDatabase db = SingletonDatabase.getInstance();

    private Patient patientObject;
    private JuniorDoctor doctorOfTask;
    private String seniorityRequired;
    private String additionalNotes;
    private String urgency;
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
       // name = patIn.getName();
//        String numMRN = patIn.getName();

//        try{
//            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
//
//            String sql = "insert into currenttasklist(patientname,mrnnumber,covidStat,urgency,tasktype, seniority, additionalnotes) values (patName,numMRN,covidStat,urgencyIn,taskDescriptIn,seniorIn, notesIn)";
//
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
    }

    public void setDoctorOfTask(JuniorDoctor docIn){
        doctorOfTask= docIn;
    }

    public JuniorDoctor getDoctorOfTask(){return doctorOfTask;
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

    public String getTaskDescript(){ return taskDescript;}

    public String getHistory(){ return history;}

    public String getNotes(){ return additionalNotes;}

    public String getSeniorityRequired(){ return seniorityRequired; }
}

