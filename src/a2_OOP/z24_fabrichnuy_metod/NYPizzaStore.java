package a2_OOP.z24_fabrichnuy_metod;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYStyleCheesePizza();
        }else if(type.equals("veggie")){
            return new NYStyleVeggiePizza();
        }else if(type.equals("pepperoni")){
            return new NYStylePepperonyPizza();
        }else return null;
    }
}