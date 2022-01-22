package com.example.nhs_handover_backend.Controllers;
import com.example.nhs_handover_backend.Entities.*;
import com.example.nhs_handover_backend.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/v1/system_controller/")
@EnableScheduling
public class SystemController {
    @Autowired
    private HospitalPersonnelService hospitalPersonnelService;
    @Autowired
    private final PatientService patientService;
    @Autowired
    private final TaskService taskService;
    @Autowired
    private ConsultantService consultantService;
    @Autowired
    private JuniorDoctorService juniorDoctorService;

    @Autowired
    public SystemController(HospitalPersonnelService hospitalPersonnelService, PatientService patientService,TaskService taskService,ConsultantService consultantService, JuniorDoctorService juniorDoctorService) {
        this.hospitalPersonnelService = hospitalPersonnelService;
        this.patientService = patientService;
        this.taskService = taskService;
        this.consultantService = consultantService;
        this.juniorDoctorService = juniorDoctorService;
    }

    @Autowired
    private JavaMailSender sender;

    @RequestMapping("/sendMail")
    @ResponseBody
    String home() {
        try {
            sendEmail();
            return "Email Sent!";
        }catch(Exception ex) {
            return "Error in sending email: "+ex;
        }
    }

    private void sendEmail() throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo("v.salem@imperial.ac.uk");
        String listString = String.join(", ", (CharSequence) taskService.getAllTasks());
        helper.setText(listString);
        helper.setSubject("Monthly Archived Task Report");
        sender.send(message);
    }


    //every monday at 9am all tasks are archived to clean up the task page and show only relevant tasks
    @Scheduled(cron = "0 0 9 * * MON")
    @GetMapping("/archiveAllTasks")
    public void archiveAllTasks() {
        taskService.archiveAllTasks();
    }

    //sends an email out once a month to the head consultant (dr.Salem) with all tasks, archived and current.
    //After email is sent all tasks are cleared from the history of the application
    @Scheduled(cron = "0 0 9 1 1/1 *")
    @GetMapping("/removeAllTasks")
    public void removeAllTasks() throws Exception {
        sendEmail();
        taskService.removeAllTasks();
        System.out.println("Scheduled task running");
    }

}