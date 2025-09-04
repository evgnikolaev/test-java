package a2_OOP.z25_abstract_fabrica.Pizza.Dough;

public class ThinCrustDough implements Dough {
    private String name = "Тонкая основа пиццы";

    @Override
    public String toString() {
        return name;
    }
}
