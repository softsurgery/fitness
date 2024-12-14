package models;

import java.io.Serializable;

public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String label;
    private float basePrice;
    private Material[] materials;
    private int nbrMaterials;

    public Activity() {}

    public Activity(String label, float basePrice, int size) {
        this.label = label;
        this.basePrice = basePrice;
        this.materials = new Material[size];
        this.nbrMaterials = 0;
    }

    public void resetMaterial(int size) {
        this.materials = new Material[size];
        this.nbrMaterials = 0;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public Material[] getMaterials() {
        return materials;
    }

    public int searchMaterials(Material material) {
        int i = 0;
        boolean found = false;
        while (i < nbrMaterials && !found) {
            if (material.getId() == materials[i].getId()) found = true;
            else i++;
        }
        return found ? i : -1; //ternary operator
    }

    public void addMaterial(Material material) {
        if (nbrMaterials < materials.length){
            if (searchMaterials(material) == -1) {
                materials[nbrMaterials] = material;
                nbrMaterials++;
            } else System.out.println("This Material has been added already");
        } else {
            System.out.println("Maximum number of materials reached");
        }
    }

    public void removeMaterial(Material material) {
        if (nbrMaterials == 0){
            System.out.println("No materials to remove");
        } else {
            int index = searchMaterials(material);
            if (index != -1) {
                for (int i = index; i < nbrMaterials - 1; i++) {
                    materials[i] = materials[i + 1];
                }
                materials[nbrMaterials - 1] = null;
                nbrMaterials--;
            } else System.out.println("This Material does not exist");
        }
    }

    @Override
    public String toString() {
        return "Activity{" +
                "label='" + label + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
