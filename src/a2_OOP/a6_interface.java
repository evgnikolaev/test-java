/*

Интерфейсы


    Интерфейсы:
        - интерфейсы - это набор абстрактных методов и статических констант
        - интерфейс - полностью статический класс
        - если класс - это модель какого-то объекта, то интерфейс больше соответствует способностям  или ролям этого объекта


    Переменные в интерфейсе - это константы
        - неявно объявляются как public, final, static
        - их нельзя изменить в классе, реализующим интерфейс
        - они обязательно должны быть инициализированы



                    public interface Moveable {
                        void moveTo(String newAddress);
                    }

                    public class Skateboard implements Moveable {
                       //реализация класса, в том числе методов интерфейса
                    }





Использование ссылок на интерфейсы

        Movable item = new Car();
        item.moveTo("home");        //вызывается метод moveTo() из класса Car



        Movable[] garage = {new Car(), new Skateboard(), new Car()};
        for (int i = 0; i < garage.length; i++) {
            garage[i].moveTo("new place");
        }






Назначение интерфейсов

    - интерфейсы, определяющие функциональность для классов
    - интерфейсы, которые придают классу опреленные свойства (например, интерфейсы Clonable и Serialize)
    - интерфейсы помогают в разработке больших проектов
        поведение
            ходить по карте
            собирать предметы
            выполнять квесты
            драться
            спасать
            общаться

        классы
            рыцарь
            король
            принцесса
            дракон





В чем отличия абстрактного класса от интерфейса?

    - Интерфейс описывает функциональность, которую могут реализовать различные, в том числе не родственные классы.
    - Любой класс может унаследовать только от одного абстрактного класса, но реализовать любое количество интерфейсов.
    - В абстрактных классах могут быть и обычные (не абстрактные методы), и поля.





Константы в интерфейсах

        public interface IConst {
            int TAX_INDIVIDUAL = 13;        //налог физлица
            int TAX_DEDUCTION_CHILD = 45;   //налоговый вычет на ребенка
        }


        public class Nalog implements IConst {
            public int calculate() {
                return (dohod - TAX_DEDUCTION_CHILD) * TAX_INDIVIDUAL / 100;            //обращение к константам из интерфейса
            }
        }



                Интерфейс констант делать плохо.
                Использование каких-то констант должно быть внутренним делом класса.
                Лучше выделить под это отдельный класс.


                public class TaxConst {
                    public static final int TAX_INDIVIDUAL = 13;        //налог физлица
                    public static final int TAX_DEDUCTION_CHILD = 45;   //налоговый вычет на ребенка

                    private TaxConst() {            //приватный конструктор делает невозможным создание объектов извне
                    }
                }

                public class Nalog {
                    public int calculate() {
                        return (dohod - TaxConst.TAX_DEDUCTION_CHILD) * TaxConst.TAX_INDIVIDUAL / 100;
                    }
                }





Вложенные интерфейсы


        public class ClassA {
            interface InnerInterf {         //доступ по умолчанию внутри пакета
                boolean isNegative(int x);
            }
        }


        // Обращение будет таким ClassA.InnerInterf
        public class ClassB implements ClassA.InnerInterf {
            @Override
            public boolean isNegative(int x) {
                return x < 0 ? true:false;
            }
        }






Новое в интерфейсах


        Методы по умолчанию (это крайнее средство):
        Позволяет расширять интерфейс, не ломаю уже написанный код

                    public interface Moveable {
                        void moveTo();

                        default void carry(String thing) { //метод с реализацией по умолчанию
                            System.out.println("Carry " + thing);
                        }
                    }


                    Недостатки методов по умолчанию:

                        -   Все усложняется, если некий класс реализует более одного (скажем, два) интерфейса,
                            в которых одинаковые методы по умолчанию. Какой из методов унаследует класс? Ответ — никакой.
                            В таком случае класс должен реализовать метод самостоятельно.

                        -   Ситуация аналогична, если класс реализует два интерфейса с одинаковыми методами.
                            Но при этом в одном интерфейсе  это метод по умолчанию, а в другом  является абстрактным.
                            В этом случае также никакой реализации методов не наследуется.





        Статические методы в интерфейсах
        Они должны иметь реализацию и при этом их нельзя переопределить в классе, реализующем интерфейс!
        Обычно используются как вспомогательные (для сортировки, проверок, логирования и т.п.)

                    public interface Moveable {
                        void moveTo();

                        static void printAddress(String address) {          //статический метод
                            System.out.println("Address = " + address);
                        }

                        default void carry(String thing) {
                            System.out.println("Carry " + thing);
                        }
                    }

                    Moveable.printAddress("Minsk");




        Приватные методы
        Могут использоваться только внутри самого интерфейса

                    public interface Moveable {
                        void moveTo();

                        static void printAddress(String address) {              //статический метод
                            if (isNotEmpty(address)) {
                                System.out.println("Address = " + address);
                            }
                        }

                        private static boolean isNotEmpty(String text) {        //статический приватный метод в интерфейсе
                            return text.isEmpty() ? false : true;
                        }
                    }





*/
package a2_OOP;

import java.util.Locale;
import java.util.Scanner;

class a6_interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        scanner.useLocale(Locale.US);


        Transport[] pets = new Transport[scanner.nextInt()];
        for (int i = 0; i < pets.length; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                pets[i] = new Lorry(scanner.nextDouble());
            }
            if (type == 2) {
                pets[i] = new Ship(scanner.nextDouble());
            }
        }

        double ves = scanner.nextDouble();

        for (int i = 0; i < pets.length; i++) {
            if (pets[i].canCarry(ves)) {
                pets[i].add(ves);
            }
            System.out.println(pets[i]);
        }
    }
}

interface Transport {
    boolean canCarry(double weight);

    void add(double weight);

    double getTotalWeight();
}

class Lorry implements Transport {
    private double maxWeight;
    private double totalWeight = 0.0;

    public Lorry(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean canCarry(double weight) {
        return maxWeight > weight;
    }

    @Override
    public void add(double weight) {
        totalWeight += weight;
    }

    @Override
    public double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Lorry{maxWeight=" + maxWeight + ", totalWeight=" + getTotalWeight() + "}";
    }
}


class Ship implements Transport {
    private double maxWeight;
    private double totalWeight = 0.0;

    public Ship(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean canCarry(double weight) {
        return maxWeight > weight;
    }

    @Override
    public void add(double weight) {
        totalWeight += weight;
    }

    @Override
    public double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Ship{maxWeight=" + maxWeight + ", totalWeight=" + getTotalWeight() + "}";
    }
}















