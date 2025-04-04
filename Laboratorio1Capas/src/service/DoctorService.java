
package service;

import model.entity.Doctor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorService {
    private List<Doctor> doctors;

    public DoctorService() {
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(String firstName, String lastName, String dui, LocalDate birthdate, LocalDate recruitmentDate, String specialty, String doctorCode) {
        Doctor newDoctor = new Doctor(firstName, lastName, dui, birthdate, recruitmentDate, specialty, doctorCode);
        doctors.add(newDoctor);
        System.out.println("Patient added");
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
                    " | Doctor Code: " + doctor.getDoctorCode());
        }
    }

    public void listDoctorCodes(){
        if (doctors.isEmpty()){
            System.out.println("No doctors registered");
            return;
        }

        System.out.println("List of doctor codes:");
        for (Doctor doctor : doctors) {
           System.out.println("Name: " + doctor.getFirstName() + " " + doctor.getLastName() + " | Doctor Code: " + doctor.getDoctorCode() + " ");
        }
    }

    public List<Doctor> getDoctorsBySpecialty(String specialty){
        return doctors.stream().filter(doctor -> doctor.getSpecialty().equalsIgnoreCase(specialty)).collect(Collectors.toList());
    }

    public List<String> getAvailableSpecialties() {
        return doctors.stream().map(Doctor::getSpecialty).distinct().collect(Collectors.toList());
    }


}
