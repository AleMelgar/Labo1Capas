package controller;

import service.DoctorService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class DoctorController {
    private Scanner scanner;
    private DoctorService doctorService;
    private Random random;

    public DoctorController(DoctorService doctorService) {
        this.scanner = new Scanner(System.in);
        this.doctorService = doctorService;
        this.random = new Random();
    }

    private String randomLetter() {
        return String.valueOf((char) ('A' + random.nextInt(26)));
    }

    private int randomDigit() {
        return random.nextInt(10);
    }

    private String generateDoctorCode() {
        return "ZNH-" + randomDigit() + randomLetter() + randomDigit() + "-" + "MD-" + randomLetter() + randomDigit();
    }

    public void addDoctor() {
        System.out.println("Doctor first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Doctor last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Doctor birthdate: (dd/MM/yyyy) ");
        String birthdateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthdate = null;
        try {
            birthdate = LocalDate.parse(birthdateString, formatter);
        } catch (Exception e) {
            System.out.println("Invalid date");
        }

        System.out.println("Doctor DUI: ");
        String dui = scanner.nextLine();

        System.out.println("Doctor specialty: ");
        String specialty = scanner.nextLine();

        System.out.println("Doctor recruitment date: (dd/MM/yyyy) ");
        String recruitmentDateString = scanner.nextLine();
        LocalDate recruitmentDate = null;
        try {
            recruitmentDate = LocalDate.parse(recruitmentDateString, formatter);
        } catch (Exception e) {
            System.out.println("Invalid date");
        }

        String doctorCode = generateDoctorCode();

        doctorService.addDoctor(firstName, lastName, dui, birthdate, recruitmentDate, specialty, doctorCode);
        System.out.println("Doctor added successfully");
    }

}
