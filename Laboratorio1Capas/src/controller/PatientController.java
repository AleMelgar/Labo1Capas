package controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import service.PatientService;
import utils.DuiValidator;

public class PatientController {
    private Scanner scanner;
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.scanner = new Scanner(System.in);
        this.patientService = patientService;
    }

    public void addPatient() {

        System.out.println("Patient first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Patient last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Patient birthdate: (dd/MM/yyyy) ");
        String birthdateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthdate = null;
        try {
            birthdate = LocalDate.parse(birthdateString, formatter);
        } catch (Exception e) {
            System.out.println("Invalid date");
        }

        assert birthdate != null;
        int age = Period.between(birthdate, LocalDate.now()).getYears();
        String dui;

        if (age < 18) {
            dui = "000000000";
        } else {
            System.out.println("Patient DUI: ");
            dui = DuiValidator.requestValidDui();
        }


        patientService.addPatient(firstName, lastName, dui, birthdate);
        System.out.println("Patient added successfully");
    }

}
