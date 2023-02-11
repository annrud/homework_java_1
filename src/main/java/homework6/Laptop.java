package homework6;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Laptop {
    private String name;
    private float size;
    private String color;
    private String material;
    private String processor;
    private int RAM;
    private int SSD;
    private String brand;
    private int price;

    public Laptop(String name, float size, String color,
                  String material, String processor,
                  int RAM, int SSD, String brand, int price) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.material = material;
        this.processor = processor;
        this.RAM = RAM;
        this.SSD = SSD;
        this.brand = brand;
        this.price = price;

    }

    @Override
    public String toString() {
        return String.format("%.1f Ноутбук %s %s %s", size, brand, name, color);
    }
}
