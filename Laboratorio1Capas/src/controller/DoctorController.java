package controller;

import service.DoctorService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DoctorController {
    private Scanner scanner;
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.scanner = new Scanner(System.in);
        this.doctorService = doctorService;
    }

    public void addDoctor() {
        System.out.println("Doctor first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Doctor last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Doctor birthdate (dd/MM/yyyy): ");
        String birthdateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthdate = null;
        try {
            birthdate = LocalDate.parse(birthdateString, formatter);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return;
        }

        System.out.println("Doctor DUI: ");
        String dui = scanner.nextLine();

        System.out.println("Doctor specialty: ");
        String specialty = scanner.nextLine();

        System.out.println("Doctor recruitment date (dd/MM/yyyy): ");
        String recruitmentDate = scanner.nextLine();

        doctorService.addDoctor(firstName, lastName, dui, birthdate, specialty, recruitmentDate);
        System.out.println("Doctor added successfully!");
    }

    public void listDoctors() {
        System.out.println("Entrando en la lista de doctores...");
        doctorService.listDoctors();
    }
}
