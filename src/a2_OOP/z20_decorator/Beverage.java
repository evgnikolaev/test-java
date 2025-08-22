package a2_OOP.z20_decorator;

// Абстрактный класс "Напиток"

public abstract class Beverage {
    private String description = "Unknown Beverage";

    public Beverage() {
    }

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
