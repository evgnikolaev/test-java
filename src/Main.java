/*


IF

        Сравнение вещественных чисел:
                Нужно стараться избегать проверки вещественных чисел на равенство!
                Такую проверку на равенство можно заменить на сравнение модуля разности чисел с очень маленьким числом (выбрано число 0.000001 == 1e-6
                if (Math.abs(x + y - z) < 1e-6) {
                    System.out.println("1/3 + 4/3 = 5/3");
                } else {
                    System.out.println("1/3 + 4/3 != 5/3");
                }





switch


                switch (выражение) {
                   case константа1:
                        последовательность_операторов_1;
                        break;
                    …
                   default:
                        последовательность_операторов_по_умолчанию;
                }

        "Выражение" должно быть типа byte, short, int, char или перечислением.
        Начиная с версии JDK 7 это выражение может иметь тип String .


        Новый синтаксис - switch может возвращать значение, используется "yield"

             int result = switch (znak) {
                        case "+" -> a + b;
                        case "/" -> {
                            if (b == 0) {
                                System.out.println("ERROR");
                                yield 0;
                            } else {
                                yield a / b;
                            }
                        }
                        default -> {
                            System.out.println("ERROR");
                            yield 0;
                        }
                    };






ЦИКЛЫ

    while(условие) оператор;

            while (kol < N) {
            }



    for(инициализация; условие_повторения; модификация)   оператор;

            for (int kol = 0; kol < N; kol++) {
            }



    do  оператор; while (условие);

            do {
            } while (x != 0);





    for (тип_данных имя_временное : имя_коллекции)    операторы; (только для чтения, элементы массива менять не можем)

            double[] b = {3.5, 6.3, 8.4};
            for (double x : b) {
                System.out.print(x + " ");
            }



 */


import java.util.Locale;
import java.util.Scanner;

public class Main {
    static final int N = 10;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        for(int i = 1; i <= height; i++) {
            for(int j = 1; j <= height; j++) {
                System.out.print(i*j);
                System.out.print("\t");
            }
            System.out.println();
        }

    }
}




















