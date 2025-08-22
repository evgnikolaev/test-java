/*


Паттерны проектирования


    Паттерн "Декоратор"
        https://stepik.org/lesson/1114992/step/3?unit=1126419

        Когда очень много различных дополнений к существующим классам.
        Пример: Сеть кофеен
        К кофе можно заказать различные дополнения (пенка, шоколад и т.д.),


*/
package a2_OOP.z20_decorator;

// Абстрактный класс "Напиток"
public abstract class Beverage {
    private String description = "Unknown Beverage";

    public Beverage() {
    }

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
