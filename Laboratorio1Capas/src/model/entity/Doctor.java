package model.entity;

import java.time.LocalDate;

public class Doctor extends Patient {
    private LocalDate recruitmentDate;
    private String specialty;
    private String doctorCode;

    public Doctor(String firstName, String lastName, String dui, LocalDate birthdate, LocalDate recruitmentDate, String specialty, String doctorCode) {
        super(firstName, lastName, dui, birthdate);
        this.recruitmentDate = recruitmentDate;
        this.specialty = specialty;
        this.doctorCode = doctorCode;
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

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

}