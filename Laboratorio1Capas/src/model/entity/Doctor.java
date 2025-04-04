package model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Doctor {
    private String firstName;
    private String lastName;
    private String dui;
    private LocalDate birthdate;
    private String specialty;
    private String recruitmentDate;
    private String epicCode;

    public Doctor(String firstName, String lastName, String dui, LocalDate birthdate, String specialty, String recruitmentDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dui = dui;
        this.birthdate = birthdate;
        this.specialty = specialty;
        this.recruitmentDate = recruitmentDate;
        this.epicCode = generateEpicCode();
    }

    private String generateEpicCode() {
        Random random = new Random();
        int x = random.nextInt(10); // Un número entero entre 0 y 9
        char a1 = (char) (random.nextInt(26) + 'A');
        char a2 = (char) (random.nextInt(26) + 'A');
        return "ZNH-" + x + a1 + x + "-MD-" + a2 + "X";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDui() {
        return dui;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getRecruitmentDate() {
        return recruitmentDate;
    }

    public String getEpicCode() {
        return epicCode;
    }
}


