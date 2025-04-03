package service;

import model.entity.Patient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private List<Patient> patients;

    public PatientService(){
        this.patients = new ArrayList<>();
    }

    public void addPatient(String firstName, String lastName, String dui, LocalDate birthdate){

        Patient newPatient = new Patient(firstName, lastName, dui, birthdate);
        patients.add(newPatient);
        System.out.println("Patient added");
    }

    public void listPatients(){
        if (patients.isEmpty()){
            System.out.println("No patients registered");
        }

        System.out.println("List of patients:");
        for (Patient patient : patients) {
            System.out.println("Name " + patient.getFirstName() + " " + patient.getLastName() + " DUI " + patient.getDui() + " Birthdate " + patient.getBirthdate());
        }
    }
}
