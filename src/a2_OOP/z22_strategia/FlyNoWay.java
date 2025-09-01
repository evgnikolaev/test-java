package a2_OOP.z22_strategia;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Я не умею летать!");
    }
}