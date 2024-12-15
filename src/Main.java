import models.Activity;
import models.Material;
import services.ActivityService;
import services.MaterialService;
import utils.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ActivityService activityService = new ActivityService("./data/activities.bin",100);
        MaterialService materialService = new MaterialService();
        activityService.loadActivities();
        int id,id2,index;
        Activity activity;
        Material material;

        while(true){
            Menu.printMenu();
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("New Activity :");
                    activity = activityService.readActivity(scanner);
                    if (activityService.addActivity(activity)) System.out.println("Activity Added Successfully");
                    activityService.dumpActivities();
                    Menu.pressEnterToContinue();
                    break;
                case 2:
                    //display activities
                    System.out.println("Activity List :");
                    activityService.printActivities();

                    //read activity id , the id must be present
                    scanner.nextLine();
                    do {
                        System.out.print("Enter the ID of the activity to add material: ");
                        id = scanner.nextInt();
                        index = activityService.searchActivityById(id);
                        if (index == -1) System.out.println("Please try again");
                    }while(index == -1);

                    System.out.println("New Material :");
                    material = materialService.readMaterial(scanner);

                    activity = activityService.getActivityById(id);
                    if(activity.addMaterial(material)) {
                        activityService.updateActivity(id, activity);
                        System.out.println("Material Added Successfully");
                    }
                    activityService.dumpActivities();
                    break;
                case 3:
                    //display activities
                    System.out.println("Activity List :");
                    activityService.printActivities();

                    //read activity id , the id must be present
                    scanner.nextLine();
                    do {
                        System.out.print("Enter the ID of the activity to update: ");
                        id = scanner.nextInt();
                        index = activityService.searchActivityById(id);
                        if (index == -1) System.out.println("Please try again");
                    }while(index == -1);

                    System.out.println("New Activity :");
                    activity = activityService.readActivity(scanner);
                    activityService.updateActivity(id, activity);
                    System.out.println("Activity Updated Successfully");
                    activityService.dumpActivities();
                    break;
                case 4:
                    System.out.println("Activity List :");
                    activityService.printActivities();

                    //read activity id , the id must be present
                    scanner.nextLine();
                    do {
                        System.out.print("Enter the ID of the activity to update its material: ");
                        id = scanner.nextInt();
                        index = activityService.searchActivityById(id);
                        if (index == -1) System.out.println("Please try again");
                    }while(index == -1);
                    activity = activityService.getActivityById(id);

                    scanner.nextLine();
                    do {
                        System.out.print("Enter the ID of the material : ");
                        id2 = scanner.nextInt();
                        index = activity.searchMaterials(id2);
                        if (index == -1) System.out.println("Please try again");
                    }while(index == -1);

                    System.out.println("New Material :");
                    material = materialService.readMaterial(scanner);

                    activity.updateMaterial(id2,material);
                    System.out.println("Material updated successfully");
                    break;
                case 5:
                    System.out.println("Activity List :");
                    activityService.printActivities();

                    //read activity id , the id must be present
                    scanner.nextLine();
                    do {
                        System.out.print("Enter the ID of the activity to remove: ");
                        id = scanner.nextInt();
                        index = activityService.searchActivityById(id);
                        if (index == -1) System.out.println("Please try again");
                    }while(index == -1);

                    if (activityService.removeActivity(id)) System.out.println("Activity removed successfully");
                    activityService.dumpActivities();
                    break;
                case 6:
                    break;
                case 7:
                    activityService.printActivities();
                    Menu.pressEnterToContinue();
                    break;
                case 8:
                    // Exit
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            scanner.nextLine();
        }
    }
}