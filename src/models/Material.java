package models;

import java.io.Serializable;

public class Material implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String label;
    private float price;

    public Material() {}

    public Material(String label, float price) {
        this.label = label;
        this.price = price;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Material with ID = " + id + ", label='" + label + ", price = " + price;
    }
}
