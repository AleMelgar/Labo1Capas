package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DoctorController {
    private Scanner scanner;

    public DoctorController() {
        this.scanner = new Scanner(System.in);
    }

    public void addDoctor() {
        System.out.println("Doctor first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Doctor last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Doctor DUI: ");
        String dui = scanner.nextLine();

        System.out.println("Doctor birthdate: ");
        String birthdateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthdate = null;
        try {
            birthdate = LocalDate.parse(birthdateString, formatter);
        } catch (Exception e) {
            System.out.println("Invalid date");
        }

        System.out.println("Doctor recruitment date: ");
        String recruitmentDateString = scanner.nextLine();
        LocalDate recruitmentDate = null;
        try {
            recruitmentDate = LocalDate.parse(recruitmentDateString, formatter);
        } catch (Exception e) {
            System.out.println("Invalid date");
        }

        System.out.println("Doctor specialty: ");
        String specialty = scanner.nextLine();

        System.out.println("Doctor epic code: ");
        String epicCode = scanner.nextLine();

    }
}
