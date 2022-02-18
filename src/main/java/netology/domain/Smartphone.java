package netology.domain;

public class Smartphone extends Product {
    private String brand;

    public Smartphone(int id, String name, int count, String brand) {
        super(id, name, count);
        this.brand = brand;
    }

}
