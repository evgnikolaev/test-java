package a2_OOP.z25_abstract_fabrica.Pizza;

import a2_OOP.z25_abstract_fabrica.PizzaIngredientFactory.PizzaIngredientFactory;

public class ClamPizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Готовим " + getName());
        //используем геттер
        //все ингредиенты запрашиваются у фабрики
        setDough(ingredientFactory.createDough());
        setSauce(ingredientFactory.createSauce());
    }
}