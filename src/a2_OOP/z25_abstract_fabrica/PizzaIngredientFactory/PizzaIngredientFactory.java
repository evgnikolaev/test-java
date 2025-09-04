package a2_OOP.z25_abstract_fabrica.PizzaIngredientFactory;

import a2_OOP.z25_abstract_fabrica.Pizza.Dough.Dough;
import a2_OOP.z25_abstract_fabrica.Pizza.Sauce.Sauce;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
}
