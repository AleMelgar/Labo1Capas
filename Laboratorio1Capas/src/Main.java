import controller.AppointmentController;
import controller.DoctorController;
import controller.PatientController;
import service.DoctorService;
import service.PatientService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientService patientService = new PatientService();
        PatientController patientController = new PatientController(patientService);
        DoctorService doctorService = new DoctorService();
        DoctorController doctorController = new DoctorController(doctorService);
        AppointmentController appointmentController = new AppointmentController(patientService, doctorService);

        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Add new patient");
            System.out.println("2. List all patients");
            System.out.println("3. Add new doctor");
            System.out.println("4. List all doctors");
            System.out.println("5. Schedule appointment");
            System.out.println("6. List all appointments");
            System.out.println("7. Search appointments by doctor");
            System.out.println("8. Search appointments by date");
            System.out.println("9. Exit");

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
                    doctorController.addDoctor();
                    break;
                case 4:
                    doctorService.listDoctors();
                    break;
                case 5:
                    appointmentController.addAppointment();
                    break;
                case 6:
                    appointmentController.listAllAppointments();
                    break;
                case 7:
                    appointmentController.searchAppointmentsByDoctor();
                    break;
                case 8:
                    appointmentController.searchAppointmentsByDate();
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
