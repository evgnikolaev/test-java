package a2_OOP.z20_decorator;

// кофе темной обжарки - основной класс

public class DarkRoast extends Beverage {

    public DarkRoast() {
        super("Dark Roast Coffee");
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
