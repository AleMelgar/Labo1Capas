package controller;

import model.entity.Appointment;
import model.entity.Doctor;
import model.entity.Patient;
import service.AppointmentService;
import service.DoctorService;
import service.PatientService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

        // Doctors by specialty
        List<String> specialties = doctorService.getAvailableSpecialties();

        if (specialties.isEmpty()) {
            System.out.println("No doctors available");
            return;
        }
        System.out.println("Choose a specialty: ");
        for (int i = 0; i < specialties.size(); i++) {
            System.out.println((i + 1) + ". " + specialties.get(i));
        }
        int specialtyIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        String specialty = specialties.get(specialtyIndex);

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

        // Date
        System.out.println("Choose a date (dd/MM/yyyy): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate date;
        while (true) {
            try {
                date = LocalDate.parse(scanner.nextLine(), formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please enter the date in dd/MM/yyyy format: ");
            }
        }

        boolean today = date.equals(LocalDate.now());

        LocalTime hour = null;

        if (today) {
            System.out.println("Choose an hour (HH:mm): ");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            while (true) {
                try {
                    hour = LocalTime.parse(scanner.nextLine(), timeFormatter);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid format. Please enter the time in HH:mm format: ");
                }
            }
        }

        appointmentService.book(doctor, patient, specialty, date, today, hour);
    }

    public void listAllAppointments() {
        appointmentService.listAllAppointments();
    }

    public void searchAppointmentsByDoctor() {

        doctorService.listDoctorCodes();
        System.out.println("Enter the doctor's code: ");
        String doctorCode = scanner.nextLine();

        List<Appointment> appointments = appointmentService.getAppointmentsByDoctor(doctorCode);
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for this doctor.");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println(appointment.showInfo());
            }
        }
    }

    public void searchAppointmentsByDate() {
        System.out.println("Enter a date (dd/MM/yyyy): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate date;
        while (true) {
            try {
                date = LocalDate.parse(scanner.nextLine(), formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please enter the date in dd/MM/yyyy format: ");
            }
        }

        List<Appointment> appointments = appointmentService.getAppointmentsByDate(date);
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for this date.");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println(appointment.showInfo());
            }
        }
    }

    public void deleteAppointment(){
        List<Appointment> appointments = appointmentService.getAllAppointments();

        if (appointments.isEmpty()){
            System.out.println("No appointments registered");
            return;
        }

        System.out.println("Choose an appointment to delete: ");
        for (int i = 0; i < appointments.size(); i++){
            System.out.println((i+1)+". "+appointments.get(i).showInfo());
        }
        int appointmentIndex = scanner.nextInt()-1;
        scanner.nextLine();
        if(appointmentIndex<0 || appointmentIndex>=appointments.size()){
            System.out.println("Invalid appointment index");
        }

        Appointment selected = appointments.get(appointmentIndex);
        appointmentService.deleteAppointment(selected);
        System.out.println("Appointment deleted successfully");
    }
}
