
package service;

import model.entity.Doctor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private List<Doctor> doctors;

    public DoctorService() {
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(String firstName, String lastName, String dui, LocalDate birthdate, String specialty, String recruitmentDate) {
        Doctor newDoctor = new Doctor(firstName, lastName, dui, birthdate, specialty, recruitmentDate);
        doctors.add(newDoctor);
        System.out.println("Doctor added successfully! Total doctors: " + doctors.size());
    }


    public void listDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered");
            return;
        }

        System.out.println("List of doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Name: " + doctor.getFirstName() + " " + doctor.getLastName() +
                    " | DUI: " + doctor.getDui() +
                    " | Birthdate: " + doctor.getBirthdate() +
                    " | Specialty: " + doctor.getSpecialty() +
                    " | Recruitment Date: " + doctor.getRecruitmentDate() +
                    " | Epic Code: " + doctor.getEpicCode());
        }
    }

}
