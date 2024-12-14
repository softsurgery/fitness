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
        activities = new Activity[capacity];
        nbrActivities = 0;
    }

    public Activity readActivity(Scanner scanner){
        scanner.nextLine();
        Activity activity = new Activity();
        System.out.print("Label : ");
        activity.setLabel(scanner.nextLine());
        System.out.print("Base Price : ");
        activity.setBasePrice(scanner.nextFloat());
        System.out.print("Maximum Material Count : ");
        activity.resetMaterial(scanner.nextInt());
        return activity;
    }

    public void addActivity(Activity activity) {
        if (nbrActivities < activities.length) {
            activities[nbrActivities++] = activity;
        } else {
            System.out.println("Activity list is full!");
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

    public void printActivities() {
        for (int i = 0; i < nbrActivities; i++) {
            System.out.println(activities[i]);
        }
    }
}
