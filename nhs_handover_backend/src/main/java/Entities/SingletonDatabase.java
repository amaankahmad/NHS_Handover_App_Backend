package Entities;

import java.util.ArrayList;

public class SingletonDatabase {
    private static SingletonDatabase single_instance = null; // Static variable for single instance of database

    ArrayList<Person> personList = new ArrayList<Person>();
    ArrayList<HospitalPersonnel> hospitalPersonList = new ArrayList<HospitalPersonnel>();
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

    public void createPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn, String numNHSIn){
        Patient pat = new Patient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
        personList.add(pat);
        patientList.add(pat);
    }

    public void createHospitalPerson(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        HospitalPersonnel doc = new HospitalPersonnel(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
        personList.add(doc);
        hospitalPersonList.add(doc);
    }

    public void createTask(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
        Task t = new Task(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
        currTaskList.add(t);
    }

    public ArrayList<Task> getPatientTask(Patient P){
        ArrayList<Task> tasksForP = new ArrayList<Task>();

        for (int i =0; i<currTaskList.size(); i++) {
            Task task = currTaskList.get(i);
            if (task.getPatient() == P) {
                tasksForP.add(task);
            }
        }

        return tasksForP;
    }

}
