package com.example.nhs_handover_backend;

//import com.example.nhs_handover_backend.Controllers.PatientController;
//import com.example.nhs_handover_backend.Repositories.*;
//import com.example.nhs_handover_backend.Entities.*;
//import com.example.nhs_handover_backend.Services.PatientService;
import com.example.nhs_handover_backend.Entities.HospitalPersonnel;
import com.example.nhs_handover_backend.Entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NhsHandoverBackendApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext =SpringApplication.run(NhsHandoverBackendApplication.class, args);

//        PersonRepository personRepository = configurableApplicationContext.getBean(PersonRepository.class)
//        JuniorDoctorRepository juniorDoctorRepository = configurableApplicationContext.getBean(JuniorDoctorRepository.class);
//        PatientRepository patientRepository = configurableApplicationContext.getBean(PatientRepository.class);
//        TaskRepository taskRepository = configurableApplicationContext.getBean(TaskRepository.class);
//
        HospitalPersonnel sacha = new HospitalPersonnel("sacha", "7th march", "female", "sachaavey@gmail.com", "1234567");
//        Person guy = new Person("guy","idk","man");
//        personRepository.save(guy);
//        PatientService patientService = new PatientService(patientRepository);
//        PatientController patientController = new PatientController(patientService);
        Patient pat = new Patient("Amaan", "1st January", "male", "Imprial College", "1111111");
//        patientController.addPatient("Kim", "1st January", "female", "Imprial College", "1111111");
//        patientRepository.save(pat);
//        Task task = new Task(pat,"Jr doctor", "nothing new", "nothing old", "ECG","15:00");
//        hospitalPersonnelRepository.save(sacha);
//        taskRepository.save(task);
//        sacha.createTask(pat,"Junior Doctor","no notes","no history","ECG","17:50");


    }

}
