package a2_OOP.z24_fabrichnuy_metod;

public abstract class PizzaStore {
    Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type); //создание экземпляра конкретного вида
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    public abstract Pizza createPizza(String type);
}