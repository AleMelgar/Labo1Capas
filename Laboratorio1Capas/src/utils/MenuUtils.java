package utils;

import controller.AppointmentController;
import controller.DoctorController;
import controller.PatientController;
import service.DoctorService;
import service.PatientService;

import java.util.Scanner;

public class MenuUtils {

    public static void doctorsMenu(Scanner scanner, DoctorController doctorController, DoctorService doctorService) {
        while (true) {
            System.out.println("\n=== Doctors Menu ===");
            System.out.println("1. Add new doctor");
            System.out.println("2. List all doctors");
            System.out.println("3. Back to Main Menu");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    doctorController.addDoctor();
                    break;
                case 2:
                    doctorService.listDoctors();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void patientsMenu(Scanner scanner, PatientController patientController, PatientService patientService) {
        while (true) {
            System.out.println("\n=== Patients Menu ===");
            System.out.println("1. Add new patient");
            System.out.println("2. List all patients");
            System.out.println("3. Back to Main Menu");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    patientController.addPatient();
                    break;
                case 2:
                    patientService.listPatients();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void appointmentsMenu(Scanner scanner, AppointmentController appointmentController) {
        while (true) {
            System.out.println("\n=== Appointments Menu ===");
            System.out.println("1. Schedule appointment");
            System.out.println("2. List all appointments");
            System.out.println("3. Delete appointment");
            System.out.println("4. Search appointments by doctor");
            System.out.println("5. Search appointments by date");
            System.out.println("6. Back to Main Menu");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    appointmentController.addAppointment();
                    break;
                case 2:
                    appointmentController.listAllAppointments();
                    break;
                case 3:
                    appointmentController.deleteAppointment();
                    break;
                case 4:
                    appointmentController.searchAppointmentsByDoctor();
                    break;
                case 5:
                    appointmentController.searchAppointmentsByDate();
                    break;
                case 6:
                    return; //
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}