package Entities;

import java.lang.reflect.Array;
import java.sql.*;
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

//    String nameIn="HELLOOO";
//    String DOBIn="HELLOOOO";
//    String patientLocationIn = "home";
//    String numMRNIn = "12345";
//    String sexIn = "idek";
    public void createPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
        Patient pat = new Patient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
        personList.add(pat);
        patientList.add(pat);

        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
            //connects

        } catch (Exception e) {
        }

        try{
            Connection conn= DriverManager.getConnection(dbUrl);


            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO patientlist(name,DOB,patientLocation,nummrn) VALUES (?, ?, ?, ?)");

            pstmt.setString(1, nameIn);
            pstmt.setString(2, DOBIn);
            pstmt.setString(3, patientLocationIn);
            pstmt.setString(4, numMRNIn);
            pstmt.executeUpdate();
            //sqlStr = "TRUNCATE TABLE patientlist;";
            //s.execute(sqlStr);
            System.out.println("it worked");

        } catch (SQLException e){
            System.out.println("it didnt work");
            e.printStackTrace();
        }
    }

    public ArrayList<Patient> getPatientList(){
        return patientList;
    }

    public void createJrDoctor(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn) {
        JuniorDoctor doc = new JuniorDoctor(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
        personList.add(doc);
        hospitalPersonList.add(doc);
        jrDoctorList.add(doc);

        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
            //connects

        } catch (Exception e) {
        }

        try{
            Connection conn= DriverManager.getConnection(dbUrl);

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO personlist(name,DOB,sex) VALUES (?, ?, ?)");
            pstmt.setString(1, nameIn);
            pstmt.setString(2, DOBIn);
            pstmt.setString(3, sexIn);
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement("INSERT INTO hospitalpersonlist(name,DOB,sex, email, numpager) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, nameIn);
            pstmt.setString(2, DOBIn);
            pstmt.setString(3, sexIn);
            pstmt.setString(4, emailIn);
            pstmt.setString(5, numPagerIn);
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement("INSERT INTO jrdoctorlist(name,DOB,sex, email, numpager) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, nameIn);
            pstmt.setString(2, DOBIn);
            pstmt.setString(3, sexIn);
            pstmt.setString(4, emailIn);
            pstmt.setString(5, numPagerIn);
            pstmt.executeUpdate();



        } catch (SQLException e){
            System.out.println("it didnt work");
            e.printStackTrace();
        }
    }

    public ArrayList<JuniorDoctor> getJrDoctorList() {
        return jrDoctorList;
    }


    public void createConsultant(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn) {
        Consultant doc = new Consultant(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
        personList.add(doc);
        hospitalPersonList.add(doc);

        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
            //connects

        } catch (Exception e) {
        }

        try{
            Connection conn= DriverManager.getConnection(dbUrl);

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO hospitalpersonlist(name,DOB,sex, email, numpager) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, nameIn);
            pstmt.setString(2, DOBIn);
            pstmt.setString(3, sexIn);
            pstmt.setString(4, emailIn);
            pstmt.setString(5, numPagerIn);
            pstmt.executeUpdate();
            //sqlStr = "TRUNCATE TABLE patientlist;";
            //s.execute(sqlStr);
            System.out.println("it worked");

        } catch (SQLException e){
            System.out.println("it didnt work");
            e.printStackTrace();
        }
    }

    public void createHospitalPersonnel(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn){
        HospitalPersonnel hospPersonnel = new HospitalPersonnel(nameIn, DOBIn, sexIn, emailIn, numPagerIn);
        hospitalPersonList.add(hospPersonnel);

        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
            //connects

        } catch (Exception e) {
        }

        try{
            Connection conn= DriverManager.getConnection(dbUrl);


            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO hospitalpersonlist(name,DOB,sex, email, numpager) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, nameIn);
            pstmt.setString(2, DOBIn);
            pstmt.setString(3, sexIn);
            pstmt.setString(4, emailIn);
            pstmt.setString(5, numPagerIn);
            pstmt.executeUpdate();
            //sqlStr = "TRUNCATE TABLE patientlist;";
            //s.execute(sqlStr);
            System.out.println("it worked");

        } catch (SQLException e){
            System.out.println("it didnt work");
            e.printStackTrace();
        }

    }

    public ArrayList<HospitalPersonnel> getHospitalPersonList(){
        return hospitalPersonList;
    }

    public void createTask(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
        Task t = new Task(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
        currTaskList.add(t);

        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
            //connects

        } catch (Exception e) {
        }
//
        try{
            Connection conn= DriverManager.getConnection(dbUrl);
////            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
////            Statement s= conn.createStatement();
////            String sqlStr = "insert into patientlist(name,DOB,patientLocation,nummrn) values('"nameIn"', '"DOBIn"', '"patientLocationIn"', '"numMRNIn"');";
////            s.execute(sqlStr);

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO currTaskList(name,DOB,sex,patientLocation,nummrn,priority, tasktype, seniority, covidstatus, schedule,additionalnotes) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
//            pstmt.setString(1, patIn.super.getName());
//            pstmt.setString(2, patIn.super.getDOB());
//            pstmt.setString(3, patIn.super.getSex());
//            pstmt.setString(4, patIn.getPatientLocation());
//            pstmt.setString(5, patIn.getNumMRN());
            pstmt.setString(6, "TBD");
            pstmt.setString(7, taskDescriptIn);
            pstmt.setString(8, seniorIn);
            pstmt.setString(9, "TBD");
            pstmt.setString(10, "TBD");
            pstmt.setString(11, notesIn);

            pstmt.executeUpdate();
            //sqlStr = "TRUNCATE TABLE patientlist;";
            //s.execute(sqlStr);
            System.out.println("it worked");
//
        } catch (SQLException e){
            System.out.println("it didnt work");
            e.printStackTrace();
        }


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
        createTask(p, seniorIn, notesIn, pastInfo[1], taskDescriptIn, creationTimeIn);
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

    public void reset() {
        for (int i = personList.size()-1; i >= 0; i--) {
            personList.remove(i);
        }
        for (int i = hospitalPersonList.size()-1; i >= 0; i--) {
            hospitalPersonList.remove(i);
        }
        for (int i = jrDoctorList.size()-1; i >= 0; i--) {
            jrDoctorList.remove(i);
        }
        for (int i = patientList.size()-1; i >= 0; i--) {
            patientList.remove(i);
        }
        for (int i = currTaskList.size()-1; i >= 0; i--) {
            currTaskList.remove(i);
        }
        for (int i = doneTaskList.size()-1; i >= 0; i--) {
            doneTaskList.remove(i);
        }

    }
}
