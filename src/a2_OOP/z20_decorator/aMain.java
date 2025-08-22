package a2_OOP.z20_decorator;

public class aMain {
    public static void main(String[] args) {
        //заказываем кофе темной обжарки
        Beverage beverage = new DarkRoast();
        //к нему один шоколад
        beverage = new Mocha(beverage);
        //и еще один шоколад
        beverage = new Mocha(beverage);
        //и взбитые сливки
        beverage = new Whip(beverage);
        //выводим описание и стоимость
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
    }
}
