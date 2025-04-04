package utils;


import model.entity.Appointment;
import model.entity.Patient;
import model.entity.Doctor;
import service.AppointmentService;
import service.DoctorService;
import service.PatientService;

import java.util.List;
import java.util.Scanner;

public class AppointmentUtils {

    public static void bookAppointment(Scanner scanner, PatientService patientService, DoctorService doctorService, AppointmentService appointmentService){
        System.out.println("Book appointment");

        // Pick patient
        List<Patient> patients = patientService.getPatients();
        if (patients.isEmpty()){
            System.out.println("No patients registered");
            return;
        }
        System.out.println("Choose a patient: ");
        for (int i = 0; i < patients.size(); i++){
            System.out.println((i+1)+". "+patients.get(i).getFirstName()+" "+patients.get(i).getLastName());
        }
        int patientIndex = scanner.nextInt()-1;
        scanner.nextLine();
        if(patientIndex<0 || patientIndex>=patients.size()){
            System.out.println("Invalid patient index");
            return;
        }
        Patient patient = patients.get(patientIndex);

        //Pick Specialty and doctor
        System.out.println("Write the specialty you need: ");
        String specialty = scanner.nextLine();

        List<Doctor> doctors = doctorService.getDoctorsBySpecialty(specialty);
        if (doctors.isEmpty()){
            System.out.println("No doctors available for this specialty");
            return;
        }

        System.out.println("Choose a doctor: ");
        for (int i = 0; i < doctors.size(); i++){
            System.out.println((i+1)+". "+doctors.get(i).getFirstName()+" "+doctors.get(i).getLastName());
        }
        int doctorIndex = scanner.nextInt()-1;
        scanner.nextLine();
        if(doctorIndex<0 || doctorIndex>=doctors.size()){
            System.out.println("Invalid doctor index");
            return;
        }

        Doctor doctor = doctors.get(doctorIndex);

        // Pick Date


    }
}
