package a2_OOP.z22_strategia;

public class DuckModelDuck extends Duck {
    public DuckModelDuck() {
        flyBehavior = new FlyNoWay(); //не умеет летать
        quackBehavior = new QuackQuack(); //крякает
    }

    @Override
    public void display() {
        System.out.println("Я - утка-приманка!");
    }
}