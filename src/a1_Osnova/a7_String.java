/*

СТРОКИ

Объекты класса String являются неизменяемыми после их создания. Все методы возвращают новую строку, исходную не меняют!



     Создание строк
                String myString = "Это тестовая строка";

                String s = new String(); //создание пустой строки
                String name = new String("Вася");


                char[] chars = {'a', 'b', 'c'};
                String s2 = new String(chars);
                System.out.println(s2); // abc

                char[] chars2 = {'a', 'b', 'c', 'd', 'e', 'f'};
                String s3 = new String(chars2,  2 начало,  3 количество);
                System.out.println(s3); // cde


        //передача кодировки в строку
        try {
            String s5 = new String(s3.getBytes(), "UTF-8");
            System.out.println(s5);
        } catch(UnsupportedEncodingException exc) {
            System.out.println("Кодировка не поддерживается");
        }



       +  - конкатенация







        Статические методы класса String

                    static String valueOf(значение) — преобразование переменной базового типа к строке
                            String str = String.valueOf(0.5);


                    static String format(String format, Object… args)— генерирует форматированную строку.

                            String result = String.format("Жили у бабуси %d веселых гуся", 2);
                            System.out.println(result);
                            double x = 3.1415;
                            String out = String.format("x=%6.3f", x);
                            System.out.println(out);




                    метод объединения строк

                    join(CharSequence delimiter, CharSequence ... elements)
                            String output = String.join(";", "1", "2", "3");

                    join(CharSequence delimiter, Iterable<? extends CharSequence> elements)
                            String[] words = str.split(" +");
                            String result = String.join(" ", words);








        сравнение строк ( происходит по коду символов ,  в лексикографическом порядке )

                    String s3 = new String("Ivan");
                    String s4 = new String("Ivan");
                    System.out.println(s3 == s4);           // false , ссылки разные

                    s3.equals(s4);      // true,  equals() - сравнивает содержимое строк
                    s3.compareTo(s4)   // Если первая строка больше, то метод возвращает положительное число, если она меньше, то отрицательное число, и 0 - если строки равны.



        Методы строк
        https://stepik.org/lesson/900807/step/5?unit=905872




 */
package a1_Osnova;

import java.util.Scanner;

class a7_String {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str = str.trim();
        String[] words = str.split(" +");

        int max = 0, k = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > max) {
                max = words[i].length();
                k = i;
            }
        }

        System.out.println(words[k]);

    }
}




















