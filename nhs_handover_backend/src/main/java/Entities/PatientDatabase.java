package Entities;

import java.util.ArrayList;

public class PatientDatabase {
    ArrayList<Person> personList = new ArrayList<Person>();
    ArrayList<HospitalPersonnel> hospitalPersonList = new ArrayList<HospitalPersonnel>();
    ArrayList<Patient> patientList = new ArrayList<Patient>();

    ArrayList<Task> currTaskList = new ArrayList<Task>();
    ArrayList<Task> doneTaskList = new ArrayList<Task>();

    public void createPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn, String numNHSIn){
        Patient pat = new Patient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
        personList.add(pat);
        patientList.add(pat);
    }

// TODO: Fix problem with passing in db reference when creating a hospital person
//    public void createHospitalPerson(String nameIn, String DOBIn, String sexIn,String hospitalIDIn, String emailIn, String numPagerIn){
//        HospitalPersonnel doc = new HospitalPersonnel(nameIn, DOBIn, sexIn, hospitalIDIn, emailIn, numPagerIn);
//        personList.add(doc);
//        hospitalPersonList.add(doc);
//    }

    public void getPatientTask(Patient P){

    }

}
