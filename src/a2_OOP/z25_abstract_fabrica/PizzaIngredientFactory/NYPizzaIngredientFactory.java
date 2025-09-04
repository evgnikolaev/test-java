package a2_OOP.z25_abstract_fabrica.PizzaIngredientFactory;

import a2_OOP.z25_abstract_fabrica.Pizza.Dough.Dough;
import a2_OOP.z25_abstract_fabrica.Pizza.Sauce.MarinaraSauce;
import a2_OOP.z25_abstract_fabrica.Pizza.Sauce.Sauce;
import a2_OOP.z25_abstract_fabrica.Pizza.Dough.ThinCrustDough;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }
}