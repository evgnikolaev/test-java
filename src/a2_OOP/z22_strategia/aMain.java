/*


Паттерны проектирования


        Паттерн "Стратегия"
        https://stepik.org/lesson/1123597/step/1?unit=1135104





*/
package a2_OOP.z22_strategia;




public class aMain {
    public static void main(String[] args) {
        DuckMallardDuck mallardDuck = new DuckMallardDuck();
        mallardDuck.display();
        mallardDuck.performQuack();
        mallardDuck.performFly();

        DuckModelDuck modelDuck = new DuckModelDuck();
        modelDuck.display();
        modelDuck.performQuack();
        modelDuck.performFly();                             //будет сообщение о неумении летать
        modelDuck.setFlyBehavior(new FlyRocketPowered());   //приделаем ракету
        modelDuck.performFly();                             //и Вот уже полет на ракете
    }
}
