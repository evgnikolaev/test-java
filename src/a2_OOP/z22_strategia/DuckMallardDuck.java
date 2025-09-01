package a2_OOP.z22_strategia;

public class DuckMallardDuck extends Duck {

    public DuckMallardDuck() {
        flyBehavior = new FlyWithWings(); //кряква летает на крыльях
        quackBehavior = new QuackQuack(); //и крякает
    }

    @Override
    public void display() {
        System.out.println("Я - кряква!");
    }
}
//и другие виды уток аналогично