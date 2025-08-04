/*

Исключения:


Throwable
    - Error                                                 - это критические ошибки.
            - StackOverflowError                            - переполнение стека вызовов
            - OutOfMemoryError                              - нехватка памяти для создания новых объектов

    -Exception                                              - менее серьезные ошибки
             - непроверяемые (unchecked)                    - не обязан предусматривать обработку в программе (хотя может это сделать, если потребуется)
                     - ArrayIndexOutOfBoundsException       - выход за границы массива)
                     - ArithmeticException                  - арифметическая ошибка, например деление на ноль
                     - NumberFormatException                - неверное преобразование символьной строки в число  и т.д.



            - проверяемые (checked)                         - это такие исключения, на которые следует обязательно реагировать в программе
                     IOExeption                             - ошибка ввода-вывода
                     SQLException                           - ошибка при обращенио к базе данных и т.д.





*/

import java.util.Locale;
import java.util.Scanner;

class Main {
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
            if(pets[i].canCarry(ves)){

            }
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

    public Lorry(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean canCarry(double weight) {
        return maxWeight > weight;
    }

    @Override
    public void add(double weight) {

    }

    @Override
    public double getTotalWeight() {
        return 0;
    }

    @Override
    public String toString() {
        return "Lorry{maxWeight=" + maxWeight + ", totalWeight=" + getTotalWeight() + "}";
    }
}


class Ship implements Transport {
    private double maxWeight;

    public Ship(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean canCarry(double weight) {
        return maxWeight > weight;
    }

    @Override
    public void add(double weight) {

    }

    @Override
    public double getTotalWeight() {
        return 0;
    }

    @Override
    public String toString() {
        return "Ship{maxWeight=" + maxWeight + ", totalWeight=" + getTotalWeight() + "}";
    }
}























