package models;

import java.io.Serializable;

public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String label;
    private float basePrice;
    private Material[] materials;
    private int nbrMaterials;

    public Activity() {}

    public Activity(int id, String label, float basePrice, int size) {
        this.id = id;
        this.label = label;
        this.basePrice = basePrice;
        this.materials = new Material[size];
        this.nbrMaterials = 0;
    }

    public void resetMaterial(int size) {
        this.materials = new Material[size];
        this.nbrMaterials = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int searchMaterials(int id) {
        int i = 0;
        boolean found = false;
        while (i < nbrMaterials && !found) {
            if (id == materials[i].getId()) found = true;
            else i++;
        }
        return found ? i : -1; //ternary operator
    }

    public boolean addMaterial(Material material) {
        if (nbrMaterials < materials.length){
            if (searchMaterials(material.getId()) == -1) {
                materials[nbrMaterials] = material;
                nbrMaterials++;
                return true;
            } else System.out.println("This Material has been added already");
        } else {
            System.out.println("Maximum number of materials reached");
        }
        return false;
    }

    public void updateMaterial(int id, Material material) {
        material.setId(id);
        int index = searchMaterials(material.getId());
        if (index!= -1) {
            materials[index] = material;
        }
    }

    public void removeMaterial(Material material) {
        if (nbrMaterials == 0){
            System.out.println("No materials to remove");
        } else {
            int index = searchMaterials(material.getId());
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
        String materialData = "";
        for (int i = 0; i < nbrMaterials; i++) {
            materialData += materials[i].toString() + "\n";
        }
        if (materialData.isEmpty()) materialData  = "No Materials found";
        else materialData = "We got " + nbrMaterials + " material(s) \n " + materialData;
        return "Activity with ID = " + id + ", label=" + label + ", base price = " + basePrice + ", Capacity = "+ materials.length + "\n" + materialData;
    }
}
