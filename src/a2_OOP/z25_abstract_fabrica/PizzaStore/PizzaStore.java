package a2_OOP.z25_abstract_fabrica.PizzaStore;

import a2_OOP.z25_abstract_fabrica.Pizza.Pizza;

public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type); //создание экземпляра конкретного вида
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    public abstract Pizza createPizza(String type);
}