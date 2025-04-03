package model.entity;

import java.time.LocalDate;

public class Patient {
    private String firstName;
    private String lastName;
    private String dui;
    private LocalDate birthdate;

    public Patient(String firstName, String lastName, String dui, LocalDate birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dui = dui;
        this.birthdate = birthdate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}

