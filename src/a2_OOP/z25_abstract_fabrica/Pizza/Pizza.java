package a2_OOP.z25_abstract_fabrica.Pizza;

import a2_OOP.z25_abstract_fabrica.Pizza.Dough.Dough;
import a2_OOP.z25_abstract_fabrica.Pizza.Sauce.Sauce;

public abstract class Pizza {
    private String name;
    private Dough dough;
    private Sauce sauce;

    //метод prepare() стал абстрактным
    abstract public void prepare();

    //остальные методы не изменились
    public void bake() {
        System.out.println("Выпекать 25 минут при температуре 350 градусов.");
    }

    public void cut() {
        System.out.println("Разрезание пиццы на диагональные ломтики");
    }

    public void box() {
        System.out.println("Поместите пиццу в официальную коробку PizzaStore");
    }

    //геттеры и сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }


    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                '}';
    }
}