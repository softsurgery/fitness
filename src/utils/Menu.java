package utils;

import java.io.IOException;

public class Menu {
    public static void printMenu() {
        System.out.println("Activity Management System");
        System.out.println("---------------------------");
        System.out.println("1. Add new subscriber");
        System.out.println("2. Add new activity");
        System.out.println("3. Add new material");
        System.out.println("4. Print all subscribers");
        System.out.println("5. Print all activities");
        System.out.println("6. Print all materials");
        System.out.println("7. Exit");
        System.out.println("---------------------------");
    }

    public static void clearConsole() throws IOException, InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            // Windows OS
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            // Unix/Linux/MacOS
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } else {
            // Unsupported OS
            System.out.println("Clear screen operation is not supported on this OS.");
        }
    }

}
