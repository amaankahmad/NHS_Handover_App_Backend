package Entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SingletonDatabase {
    private static SingletonDatabase single_instance = null; // Static variable for single instance of database

    ArrayList<Person> personList = new ArrayList<Person>();
    ArrayList<HospitalPersonnel> hospitalPersonList = new ArrayList<HospitalPersonnel>();
    ArrayList<JuniorDoctor> jrDoctorList = new ArrayList<JuniorDoctor>();
    ArrayList<Patient> patientList = new ArrayList<Patient>();

    ArrayList<Task> currTaskList = new ArrayList<Task>();
    ArrayList<Task> doneTaskList = new ArrayList<Task>();

    private SingletonDatabase() {
        // Making the constructor private, so we cannot call new SingletonDatabase() anymore
    }

    // Static method to create instance of Singleton class
    public static SingletonDatabase getInstance() {
        if (single_instance == null) {
            single_instance = new SingletonDatabase();
        }
        return single_instance;
    }

    public void createPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
        Patient pat = new Patient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
        personList.add(pat);
        patientList.add(pat);
    }

    public ArrayList<Patient> getPatientList(){
        return patientList;
    }

    public void createJrDoctor(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn) {
        JuniorDoctor doc = new JuniorDoctor(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
        personList.add(doc);
        hospitalPersonList.add(doc);
        jrDoctorList.add(doc);
    }

    public void createConsultant(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn) {
        Consultant doc = new Consultant(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
        personList.add(doc);
        hospitalPersonList.add(doc);
    }

    public void createTask(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
        Task t = new Task(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
        currTaskList.add(t);
    }

    public void archiveTask(Task completed) {
        currTaskList.remove(completed);
        doneTaskList.add(completed);
    }

    public void createFollowUp(Task completed, String seniorIn, String notesIn, String taskDescriptIn, String creationTimeIn) {
        archiveTask(completed);
        Patient p = completed.getPatient();
        String[] pastInfo = completed.getTaskInfo();
        notesIn = notesIn + "\nAdditional Notes from Previous Task: \n" + pastInfo[0];
        Task followUp = new Task(p, seniorIn, notesIn, pastInfo[1], taskDescriptIn, creationTimeIn);
    }

    public ArrayList<HospitalPersonnel> getHospitalPersonList(){
        return hospitalPersonList;
    }

    public ArrayList<JuniorDoctor> getJrDoctorList() {
        return jrDoctorList;
    }

    public ArrayList<Task> getCurrTaskList(){
        return currTaskList;
    }

    public ArrayList<Task> getDoneTaskList(){
        return doneTaskList;
    }

    public ArrayList<Task> getPatientTasks(Patient P){
        ArrayList<Task> tasksForP = new ArrayList<Task>();

        for (int i =0; i<currTaskList.size(); i++) {
            Task task = currTaskList.get(i);
            if (task.getPatient() == P) {
                tasksForP.add(task);
            }
        }

        return tasksForP;
    }

    public ArrayList<Task> getDoctorTasks(Doctor doc){
        ArrayList<Task> tasksForDoc = new ArrayList<Task>();

        for (int i =0; i<currTaskList.size(); i++) {
            Task task = currTaskList.get(i);
            if (task.getDoctorOfTask() == doc) {
                tasksForDoc.add(task);
            }
        }

        return tasksForDoc;
    }

    public ArrayList<ArrayList<Task>> getDoctorTasks(){
        ArrayList<ArrayList<Task>> tasksForAll = new ArrayList<ArrayList<Task>>();

        for (int i =0; i<jrDoctorList.size(); i++) {
            ArrayList<Task> tasksForDoc = new ArrayList<Task>();
            for (int j = 0; j < currTaskList.size(); j++) {
                Task task = currTaskList.get(j);
                if (task.getDoctorOfTask() == jrDoctorList.get(i)) {
                    tasksForDoc.add(task);
                }
            }
            tasksForAll.add(tasksForDoc);
        }

        return tasksForAll;
    }
}
