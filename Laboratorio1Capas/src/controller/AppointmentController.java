package controller;

import model.entity.Doctor;
import model.entity.Patient;
import service.DoctorService;
import service.PatientService;
import service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class AppointmentController {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final AppointmentService appointmentService;

    public AppointmentController(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.appointmentService = new AppointmentService();
    }

    public void addAppointment() {
        System.out.println("\nAdd an appointment: ");

        // Patient
        List<Patient> patients = patientService.getPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients registered");
            return;
        }
        System.out.println("Choose a patient: ");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).getFirstName() + " " + patients.get(i).getLastName());
        }
        int patientIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        Patient patient = patients.get(patientIndex);

        //Doctors by specialty
        System.out.println("Write the specialty you need: ");
        String specialty = scanner.nextLine();

        List<Doctor> doctors = doctorService.getDoctorsBySpecialty(specialty);
        if (doctors.isEmpty()) {
            System.out.println("No doctors available for this specialty");
            return;
        }
        System.out.println("Choose a doctor: ");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).getFirstName() + " " + doctors.get(i).getLastName());
        }
        int doctorIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        Doctor doctor = doctors.get(doctorIndex);

        //Date
        System.out.println("Choose a date: (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        boolean today = date.equals(LocalDate.now());

        LocalTime hour = null;
        if (today){
            System.out.println("Choose an hour: (HH:mm): ");
            hour = LocalTime.parse(scanner.nextLine());
        }

        appointmentService.book(doctor, patient, specialty, date, today, hour);

    }
}
