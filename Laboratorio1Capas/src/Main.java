import controller.AppointmentController;
import controller.DoctorController;
import controller.PatientController;
import service.DoctorService;
import service.PatientService;
import utils.MenuUtils;

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
            System.out.println("1. Doctors");
            System.out.println("2. Patients");
            System.out.println("3. Appointments");
            System.out.println("4. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    MenuUtils.doctorsMenu(scanner, doctorController, doctorService);
                    break;
                case 2:
                    MenuUtils.patientsMenu(scanner, patientController, patientService);
                    break;
                case 3:
                    MenuUtils.appointmentsMenu(scanner, appointmentController);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}