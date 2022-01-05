package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Patient extends Person {
    private String patientLocation;
    private String numMRN;

    public Patient(String nameIn, String DOBIn, String sexIn, String patientLocationIn, String numMRNIn){
        super(nameIn,DOBIn,sexIn);
        patientLocation= patientLocationIn;
        numMRN=numMRNIn;

//        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
//        try {
//            // Registers the driver
//            Class.forName("org.postgresql.Driver");
//            //connects
//
//        } catch (Exception e) {
//        }
//
//        try{
//            Connection conn= DriverManager.getConnection(dbUrl);
//            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
//            Statement s= conn.createStatement();
//            String sqlStr = "insert into patientlist(id,name,DOB,patientLocation,nummrn,covidstatus) values(3,1,1,1,1,1);";
//            s.execute(sqlStr);
//            sqlStr = "TRUNCATE TABLE patientlist;";
//            s.execute(sqlStr);
//            System.out.println("it worked");
//
//        } catch (SQLException e){
//            System.out.println("it didnt work");
//            e.printStackTrace();
//        }

//        try {
//            Statement s=conn.createStatement();
//            String sqlStr = "INSERT INTO patientofdoctor (patientid,doctorid) values (1,2);”;
//            s.execute(sqlStr);
//            sqlStr = "INSERT INTO patientofdoctor (patientid,doctorid) values (2,2);”;
//            s.execute(sqlStr);
//            s.close();
//            conn.close();
//        }
//        catch (Exception e){
//        }
    }

    public String getNumMRN(){
        return numMRN;
    }

    public String getPatientLocation(){
        return patientLocation;
    }

    public void setPatientLocation(String patLoc){
        patientLocation=patLoc;
    }
}
