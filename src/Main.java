/*

МАССИВЫ







 */


import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        double z = scan.nextDouble();
        System.out.printf("%.2f %.2f\n", average(a, b), average(a, b, c));
        System.out.printf("%.2f %.2f\n", average(x, y),average(x, y, z));


    }
    static double average(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }
    static double average(double a, double b) {
        return (a + b ) / 2.0;
    }
}




















