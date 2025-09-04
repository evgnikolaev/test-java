package a2_OOP.z25_abstract_fabrica.Pizza.Dough;

public class ThickCrustDough implements Dough {
    private String name = "Толстая основа пиццы";

    @Override
    public String toString() {
        return name;
    }
}
