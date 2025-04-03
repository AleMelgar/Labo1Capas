package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PatientController {
    private Scanner scanner;

    public PatientController() {
        this.scanner = new Scanner(System.in);
    }

    public void addPatient() {

        System.out.println("Patient first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Patient last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Patient DUI: ");
        String dui = scanner.nextLine();

        System.out.println("Patient birthdate: ");
        String birthdateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate birthdate = LocalDate.parse(birthdateString, formatter);
        } catch (Exception e) {
            System.out.println("Invalid date");
        }
    }
}
