package model.entity;

import java.time.LocalDate;

public class Patient {
    private String firstName;
    private String lastName;
    private String dui;
    private LocalDate birthday;

    public Patient(String firstName, String lastName, String dui, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dui = dui;
        this.birthday = birthday;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}

