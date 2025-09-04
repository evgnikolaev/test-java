package a2_OOP.z25_abstract_fabrica.PizzaIngredientFactory;

import a2_OOP.z25_abstract_fabrica.Pizza.Dough.Dough;
import a2_OOP.z25_abstract_fabrica.Pizza.Sauce.PlumTomatoSauce;
import a2_OOP.z25_abstract_fabrica.Pizza.Sauce.Sauce;
import a2_OOP.z25_abstract_fabrica.Pizza.Dough.ThickCrustDough;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }
}