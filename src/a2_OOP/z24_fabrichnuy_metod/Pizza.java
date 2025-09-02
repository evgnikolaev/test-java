package a2_OOP.z24_fabrichnuy_metod;

import java.util.ArrayList;

public abstract class Pizza {
    private String name; //название
    private String dough; //тип основы
    private String sauce; //тип соуса
    private ArrayList toppings = new ArrayList(); //список добавок

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public ArrayList getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList toppings) {
        this.toppings = toppings;
    }

    public void prepare() {
        System.out.println("Готовим " + name);
        System.out.println("Замешиваем тесто ...");
        System.out.println("Добавляем соус ...");
        System.out.println("Добавляем добавки: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(" " + toppings.get(i));
        }
    }

    public void bake() {
        System.out.println("Выпекаем 25 минут при температуре 350");
    }

    public void cut() {
        System.out.println("Разрезаем пиццу на диагональные ломтики");
    }

    public void box() {
        System.out.println("Помещаем пиццу в официальную коробку PizzaStore");
    }
}