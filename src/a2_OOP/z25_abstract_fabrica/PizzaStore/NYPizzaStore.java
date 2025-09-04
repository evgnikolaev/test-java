package a2_OOP.z25_abstract_fabrica.PizzaStore;

import a2_OOP.z25_abstract_fabrica.Pizza.CheesePizza;
import a2_OOP.z25_abstract_fabrica.Pizza.ClamPizza;
import a2_OOP.z25_abstract_fabrica.Pizza.Pizza;
import a2_OOP.z25_abstract_fabrica.PizzaIngredientFactory.NYPizzaIngredientFactory;
import a2_OOP.z25_abstract_fabrica.PizzaIngredientFactory.PizzaIngredientFactory;

public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        //фабрика производит ингредиенты для всех пицц в нью-йоркском стиле
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Сырная пицца в стиле Нью-Йорк");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Пицца с малюсками в стиле Нью-Йорк");
        }
        //здесь может быть код построения других видов пицц
        return pizza;
    }
}