import controller.PatientController;
import service.PatientService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientService patientService = new PatientService();
        PatientController patientController = new PatientController(patientService);

        while(true){
            System.out.println("\n Main Menu");
            System.out.println("1. Add new patient");
            System.out.println("2. List all patients");
            System.out.println("3. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    patientController.addPatient();
                    break;
                case 2:
                    patientService.listPatients();
                    break;
                case 3:
                    System.exit(0);
            }
        }

    }
}