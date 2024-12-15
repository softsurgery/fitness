package services;

import models.Activity;

import java.io.*;
import java.util.Scanner;

public class ActivityService {
    private Activity[] activities;
    private int nbrActivities;
    private String filepath;

    public ActivityService(String filepath, int capacity) {
        this.filepath = filepath;
        this.activities = new Activity[capacity];
        this.nbrActivities = 0;
    }

    public Activity readActivity(Scanner scanner){
        //clean stdin (buffer)
        scanner.nextLine();

        //create an activity object
        Activity activity = new Activity();

        //read activity's id
        System.out.print("ID : ");
        activity.setId(scanner.nextInt());
        scanner.nextLine();

        //read activity's label
        System.out.print("Label : ");
        activity.setLabel(scanner.nextLine());

        //read activity's base price
        System.out.print("Base Price : ");
        activity.setBasePrice(scanner.nextFloat());

        //read activity's max material count
        System.out.print("Maximum Material Count : ");
        activity.resetMaterial(scanner.nextInt());
        return activity;
    }

    public int searchActivityById(int id) {
        int i = 0;
        boolean found = false;
        while (i < nbrActivities && !found) {
            if (activities[i].getId() == id) found = true;
            else i++;
        }
        return found ? i : -1;
    }

    public boolean addActivity(Activity activity) {
        if (nbrActivities < activities.length) {
            if (searchActivityById(activity.getId()) == -1){
                activities[nbrActivities] = activity;
                nbrActivities++;
                return true;
            } else {
                System.out.println("Activity is already added");
            }
        } else {
            System.out.println("Activity list is full!");
        }
        return false;
    }

    public boolean removeActivity(int id){
        int index = searchActivityById(id);
        if (index!= -1) {
            for (int i = index; i < nbrActivities - 1; i++) {
                activities[i] = activities[i + 1];
            }
            activities[nbrActivities - 1] = null;
            nbrActivities--;
            return true;
        } else {
            System.out.println("Activity not found!");
        }
        return false;
    }

    public void updateActivity(int id, Activity activity) {
        activity.setId(id);
        int index = searchActivityById(id);
        if (index!= -1) {
            activities[index] = activity;
        }
    }

    public void dumpActivities() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(activities);
            oos.writeInt(nbrActivities);
            System.out.println("Activities saved to " + filepath);
        } catch (IOException e) {
            System.out.println("Error saving activities: " + e.getMessage());
        }
    }

    public void loadActivities() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            activities = (Activity[]) ois.readObject();
            nbrActivities = ois.readInt();
            System.out.println("Activities loaded from " + filepath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading activities: " + e.getMessage());
        }
    }

    public Activity getActivityById(int id) {
        int index = searchActivityById(id);
        return index!= -1 ? activities[index] : null;
    }


    public void printActivities() {
        if (nbrActivities == 0) {
            System.out.println("No activities found!");
            return;
        }
        for (int i = 0; i < nbrActivities; i++) {
            System.out.println(activities[i]);
        }
    }
}
