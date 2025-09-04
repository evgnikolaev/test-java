package a2_OOP.z25_abstract_fabrica.Pizza;

import a2_OOP.z25_abstract_fabrica.PizzaIngredientFactory.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Готовим " + getName());//поскольку поле суперкласса приватное,
        //используем геттер
        //все ингредиенты запрашиваются у фабрики
        setDough(ingredientFactory.createDough());
        setSauce(ingredientFactory.createSauce());

    }
}
