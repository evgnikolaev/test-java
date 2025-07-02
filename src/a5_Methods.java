/*

МЕТОДЫ

    [модификаторы]тип имя_метода ([список_параметров]){
        //тело_метода
    }



    public static void main(String[] args) {
    }







    Аргументы в метод передаются по значению. Всегда! (В отличие от других языков, в Java нет передачи параметра по ссылке!)

                public class Runner {

                   public static void main(String[] args) {
                        StringBuilder filename = new StringBuilder("data");
                        addExtention(filename);                                             //передача в метод ссылки на объект
                        System.out.println("Имя файла c расширением: " + filename);
                    }

                    static void addExtention(StringBuilder sb){                         //передача в метод ссылки на объект (filename и sb - ссылаются на одно и тоже)
                        sb.append(".txt"); //добавление символов в строку
                    }
                }





Перегрузка методов


        Сигнатура - имя + список параметров. Возвращаемый тип не входит в сигнатуру
        Параметры могут отличаться
            - количеством
            - типом
            - последовательностью



        public class Example6 {

            public static void main(String[] args) {
                print(5);                               //вызов первого перегруженного метода
                print(6, 7);                            //вызов второго перегруженного метода
                print(8, 9, 10);                        //вызов третьего перегруженного метода
            }

            static void print(int a){
                System.out.println(a);
            }

            static void print(int a, int b){
                System.out.println(a + " " + b);
            }

            static void print(int a, int b, int c){
                System.out.println(a + " " + b + " " + c);
            }



    При перегрузках может происходит расширение типов



 */


import java.util.Locale;
import java.util.Scanner;

class a5_Methods {
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




















