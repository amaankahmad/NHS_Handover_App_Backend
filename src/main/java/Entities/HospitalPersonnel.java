package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HospitalPersonnel extends Person {
    SingletonDatabase db = SingletonDatabase.getInstance();

    private String email;
    private String numPager;

    public HospitalPersonnel(String nameIn, String DOBIn, String sexIn, String emailIn, String numPagerIn) {
        super(nameIn, DOBIn, sexIn);
        email = emailIn;
        numPager = numPagerIn;
    }

    public String getNumPager(){
        return  numPager;
    }

    public String getEmail(){
        return email;
    }

    public void addPatient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
        db.createPatient(nameIn, DOBIn, sexIn, patientLocationIn, numMRNIn);
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
            //connects

        } catch (Exception e) {
        }

        try{
            Connection conn= DriverManager.getConnection(dbUrl);
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
            Statement s= conn.createStatement();
            String sqlStr = "insert into patientlist(id,name,DOB,patientLocation,nummrn,covidstatus) values(3,1,1,1,1,1);";
            s.execute(sqlStr);
//            sqlStr = "TRUNCATE TABLE patientlist;";
//            s.execute(sqlStr);
            System.out.println("it worked");

        } catch (SQLException e){
            System.out.println("it didnt work");
            e.printStackTrace();
        }
    }

    public void createTask(Patient patIn, String seniorIn, String notesIn, String historyIn, String taskDescriptIn, String creationTimeIn){
        db.createTask(patIn, seniorIn, notesIn, historyIn, taskDescriptIn, creationTimeIn);
    }
}
