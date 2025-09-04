/*


Паттерны проектирования


    Паттерн "Абстрактная фабрика"
        https://stepik.org/lesson/1114992/step/3?unit=1126419



*/
package a2_OOP.z25_abstract_fabrica;


import a2_OOP.z25_abstract_fabrica.Pizza.Pizza;
import a2_OOP.z25_abstract_fabrica.PizzaStore.ChicagoPizzaStore;
import a2_OOP.z25_abstract_fabrica.PizzaStore.NYPizzaStore;
import a2_OOP.z25_abstract_fabrica.PizzaStore.PizzaStore;

public class aMain {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore(); //создаем пиццерию в Нью-Йорке
        Pizza pizza = nyStore.orderPizza("cheese"); //заказываем сырную пиццу
        System.out.println("Петя заказал - " + "\n" + pizza + "\n");

        System.out.println();
        PizzaStore chicagoStore = new ChicagoPizzaStore(); //создаем пиццерию в Чикаго
        pizza = chicagoStore.orderPizza("clam"); //заказываем пиццу с малюсками
        System.out.println("Вася заказал - " + "\n" + pizza + "\n");
    }
}
