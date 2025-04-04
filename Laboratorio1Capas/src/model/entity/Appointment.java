package model.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String specialty;
    private LocalDate date;
    private LocalTime hour;
    private boolean assisted;

    public Appointment(Doctor doctor, Patient patient, String specialty, LocalDate date, LocalTime hour) {
        this.doctor = doctor;
        this.patient = patient;
        this.specialty = specialty;
        this.date = date;
        this.hour = hour;
        this.assisted = true;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public boolean isAssisted() {
        return assisted;
    }

    public void setAssisted() {
        this.assisted = true;
    }

    public String showInfo(){
        return String.format(
          "Appointment - Date: %s | Hour: %s | Doctor: %s | Patient: %s | Specialty: %s | Confirmed: %s",
          date, hour, doctor.getFirstName() + " " + doctor.getLastName(), patient.getFirstName() + " " + patient.getLastName(), specialty, assisted ? "Yes":"No"
        );
    }
}
