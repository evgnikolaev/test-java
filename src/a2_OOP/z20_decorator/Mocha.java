package a2_OOP.z20_decorator;

// Добавляем дополнение "Шоколад"

public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        //к описанию основного напитка добавляем "Mocha"
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        //к стоимости основного напитка добавляем 0.2
        return 0.2 + beverage.cost();
    }
}