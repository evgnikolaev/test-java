/*

StringBuffer и StringBuilder

Объекты класса String являются неизменяемыми после их создания. Все методы возвращают новую строку, исходную не меняют!

StringBuffer и StringBuilder - изменяют текущий объект, строку (удобно например когда в цикле формируем строку) .  (StringBuffer - просто потокобезопасный, используют при многопоточности, StringBuilder - быстрее)
StringBuffer и StringBuilder - ссылочный тип данных.


        // 1 Создание StringBuilder
                    //StringBuilder sb = "test";                        // ошибка, литералом не создать
                    StringBuilder sb1 = new StringBuilder("test");
                    StringBuilder sb4 = new StringBuilder(sb1);         // на основе другого StringBuilder


        // 2 Емкость и длина
                    StringBuilder sb2 = new StringBuilder();            // по умолчанию емкость 16
                    StringBuilder sb3 = new StringBuilder(50); // емкость 50

                    StringBuilder sb1 = new StringBuilder("test");
                    sb1.capacity();                                     // выводит 20
                    sb1.length();                                       // выводит 4
                    sb2.ensureCapacity(32);                             // выводит 34, задается именно минимальная емкость, а текущая емкость может оказаться и больше.
                    sb1.setLength(20);                                  // Если существующая длина строки больше указанной в методе, то он обрежет строку до нужного размера.
                                                                        // А если текущая длина строки меньше заданной - то дополнит непечатаемыми символами. (лучше не оспользовать)


        // 3 Преобразовывание друг в друга.
                    String str = sb1.toString();                        // преобразование в строку
                    StringBuilder sb5 = new StringBuilder(str);         // преобразование в StringBuilder


        // 4 Проверка на равенство
                    StringBuilder s1 = new StringBuilder("Java");
                    StringBuilder s2 = new StringBuilder("Java");
                    System.out.println(s1.toString().contentEquals(s2)); // true, сравнение содержимых делается так.  Потому что
                                                                         //         s1 == s2      // false, т.к. разные ссылочные переменные
                                                                         //         s1.equals(s2) // тоже false, т.к. метод equals() также сравнивает ссылочные переменные, Ну и может отличаться длина и емкость


        // 5 Методы StringBuilder
                    StringBuilder sb = new StringBuilder("I do not like java!");
                    sb.append('-').append("test");                      // добавление значений цепочкой

                    sb.insert(2, "love ");                              // 2 - индекс символа, начиная с которого будет вставлена строк

                    sb.delete(2, 9);                                    // удаленрие (индекс начала, индекс конца, не включена)

                    sb.reverse();                                       // поменять порядок символов на обратный



        // 6 Нюансы
                    В классе StringBuilder присутствуют также методы, аналогичные методам класса String, такие как replace(), substring(), charAt(), length(), getChars(), indexOf() и др.
                    Есть некоторые особенности, различия использования этих методов, в отличие от класса String.


                    в метод indexOf() нельзя передать символ, а только строку:
                                StringBuilder test = new StringBuilder("abracadabra");
                                //int ind = test.indexOf('c'); //ошибка
                                int ind = test.indexOf("c");


                    метод substring() возвращает не StringBuilder (как можно было бы подумать), а String:
                                //StringBuilder tt = test.substring(4, 9); //ошибка
                                String tt = test.substring(4, 9);


                    А метод replace() вообще работает по-другому:
                                StringBuilder test = new StringBuilder("abracadabra");
                                test.replace(2,5,"XX"); //с индекса 2 по 4 включительно, заменяется на XX





 */


import java.util.Scanner;

class a8_StringBuilder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        String str = primer(a, b);
        System.out.println(str);
    }

    public static String primer(int a, int b) {
        int sum = a + b;
        return new StringBuilder(a + " + " + b + " = " + sum).toString();
    }
}




















