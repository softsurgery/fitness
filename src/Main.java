import models.Activity;
import services.ActivityService;
import utils.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ActivityService activityService = new ActivityService("./data/activities.bin",100);
        activityService.loadActivities();
        Activity activity;

        while(true){
            Menu.clearConsole();
            Menu.printMenu();
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    // Add new subscriber
                    break;
                case 2:
                    activity = activityService.readActivity(scanner);
                    activityService.addActivity(activity);
                    System.out.println("Activity Added Successfully");
                    break;
                case 3:
                    // Add new material
                    break;
                case 4:
                    // Print all subscribers
                    break;
                case 5:
                    activityService.printActivities();
                    break;
                case 6:
                    // Print all materials
                    break;
                case 7:
                    // Exit
                    activityService.dumpActivities();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            scanner.nextLine(); // Consume newline character after reading int input.

            // Additional logic to handle user input and perform desired operation.

            // Example:
            // if (choice == 2) {
            //     System.out.print("Enter activity label: ");
        }
    }
}