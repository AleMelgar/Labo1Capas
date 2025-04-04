package model.entity;

import java.time.LocalDate;

public class Doctor extends Patient {
    private LocalDate recruitmentDate;
    private String specialty;
    private String epicCode;

    public Doctor(String firstName, String lastName, String dui, LocalDate birthdate, LocalDate recruitmentDate, String specialty, String epicCode) {
        super(firstName, lastName, dui, birthdate);
        this.recruitmentDate = recruitmentDate;
        this.specialty = specialty;
        this.epicCode = epicCode;
    }

    public LocalDate getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(LocalDate recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getEpicCode() {
        return epicCode;
    }

    public void setEpicCode(String epicCode) {
        this.epicCode = epicCode;
    }

}