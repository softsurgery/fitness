package models;

public class Material {
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
        return "Material{" +
                "label='" + label + '\'' +
                ", price=" + price +
                '}';
    }
}
