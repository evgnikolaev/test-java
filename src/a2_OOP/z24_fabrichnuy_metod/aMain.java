/*


Паттерны проектирования


    Паттерн "Декоратор"
        https://stepik.org/lesson/1114992/step/3?unit=1126419

        Когда очень много различных дополнений к существующим классам.
        Пример: Сеть кофеен
        К кофе можно заказать различные дополнения (пенка, шоколад и т.д.),


*/
package a2_OOP.z24_fabrichnuy_metod;



public class aMain {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore(); //создаем пиццерию в Нью-Йорке
        Pizza pizza = nyStore.orderPizza("cheese"); //заказываем сырную пиццу
        System.out.println("Петя заказал - " + pizza.getName() + "\n");

        PizzaStore chicagoStore = new ChicagoPizzaStore(); //создаем пиццерию в Чикаго
        pizza = chicagoStore.orderPizza("cheese"); //заказываем сырную пиццу
        System.out.println("Вася заказал " + pizza.getName() + "\n");
    }
}
