package utils;

import java.io.IOException;

public class Menu {
    public static void printMenu() {
        System.out.println("Activity Management System");
        System.out.println("---------------------------");
        System.out.println("1. Add new activity");
        System.out.println("2. Add new material");
        System.out.println("3. Edit activity");
        System.out.println("4. Edit material");
        System.out.println("5. Remove activity");
        System.out.println("6. Remove material");
        System.out.println("7. Print all activities");
        System.out.println("8. Exit");
        System.out.println("---------------------------");
    }

    public static void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        try{ System.in.read();}
        catch(Exception e) {}
    }

}
