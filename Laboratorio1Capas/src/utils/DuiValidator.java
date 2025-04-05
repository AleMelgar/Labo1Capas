package utils;

import java.util.Scanner;

public class DuiValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static String requestValidDui() {
        String dui;
        while (true) {
            dui = scanner.nextLine();
            if (dui.matches("\\d{9}")) {
                return dui;
            } else {
                System.out.println("Invalid DUI. It must contain exactly 9 digits.");
            }
        }
    }
}
