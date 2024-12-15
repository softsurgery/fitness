package services;

import models.Material;

import java.util.Scanner;

public class MaterialService {

    public Material readMaterial(Scanner scanner){
        scanner.nextLine();
        Material material = new Material();
        System.out.print("ID : ");
        material.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Label : ");
        material.setLabel(scanner.nextLine());
        System.out.print("Price : ");
        material.setPrice(scanner.nextFloat());
        return material;
    }
}
