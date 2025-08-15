/*

Полиморфизм при использовании дженериков


        При использовании обычного синтаксиса параметризованных коллекций существуют
        определенные проблемы в реализации полиморфизма.

        Так, если объявлен метод, который принимает ArrayList<Animal>,
        то в этот метод мы не можем передать ни ArrayList<Dog>, ни ArrayList<Cats>
        (даже если Dogs и Cats являются наследниками  Animals).


        Для того чтобы сработало нужно в методе укзать
        ArrayList<? extends Animals> list


*/
package a2_OOP;

import java.util.ArrayList;

public class a16_polimorfizm_jeneric {
    public static void main(String[] args) {

        /*
            тут ок, в метод feedAnimals  передаем ArrayList<Animals>
            ArrayList<Animals> animalList = new ArrayList<Animals>();
            animalList.add(new Dogs());
            animalList.add(new Cats());
            animalList.add(new Animals());
            feedAnimals(animalList);
        */


        /*
            тут уже не ок,  в метод feedAnimals передаем  ArrayList<Dog>
            для того чтобы сработало нужно в методе  feedAnimals
            ArrayList<? extends Animals> list
        */

        ArrayList<Dogs> svora = new ArrayList<Dogs>();
        svora.add(new Dogs());
        svora.add(new Dogs());
        feedAnimals(svora);
    }



    /*
        public static void feedAnimals(ArrayList<Animals> list) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).eat();
            }
        }
    */

    public static void feedAnimals(ArrayList<? extends Animals> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).eat();
        }
    }


}

class Animals {
    public void eat() {
        System.out.println("Животное ест");
    }
}

class Cats extends Animals {
    @Override
    public void eat() {
        System.out.println("Кот ест");
    }
}

class Dogs extends Animals {
    @Override
    public void eat() {
        System.out.println("Собака ест");
    }
}




