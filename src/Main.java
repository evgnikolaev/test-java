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




 */


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int distAB = sc.nextInt();
        int distBC = sc.nextInt();
        int ves = sc.nextInt();

        int bak = 300;

        int potreblenie = 1;
        if (ves <= 500) {
            potreblenie = 1;
        } else if (ves > 500 & ves <= 1000) {
            potreblenie = 4;
        } else if (ves > 1000 & ves <= 1500) {
            potreblenie = 7;
        } else if (ves > 1500 & ves <= 2000) {
            potreblenie = 9;
        } else {
            System.out.println("ERROR");
            return;
        }


        if (potreblenie * distAB > bak) {
            System.out.println("ERROR");
            return;
        }
        if (potreblenie * distBC > bak) {
            System.out.println("ERROR");
            return;
        }

        int ostatokAB = bak - (potreblenie * distAB);
        double toplivo = (distBC * potreblenie) - ostatokAB;
        if (toplivo < 0) {
            toplivo = 0;
        }
        System.out.printf("%.2f", toplivo);
    }
}






















