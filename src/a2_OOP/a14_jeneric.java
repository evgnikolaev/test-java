/*

Дженерики


    Динамический массив
        ArrayList<Student> list = new ArrayList<Student>();     // список студентов
        ArrayList<Student> list = new ArrayList<>();            // список студентов (во 2-ой части не указан тип)
        ArrayList<Student> list = new ArrayList<>(15);          // список студентов (с емкостью 15, по умолчанию 10)
                                                                // Если емкости становится недостаточно, то размер
                                                                // увеличивается в полтора раза плюс еще один элемент.




    Основные методы класса ArrayList
    буквой E обозначен тип элементов списка ArrayList - в нашем примере это класс Student

            1. void add([int индекс,] Е объект)    - добавляет заданный объект в список по указанному индексу.
                                                     Введенные ранее элементы подвигаются вправо, начиная с указанного индекса.
                                                     Т.е. происходит вставка, а не замена элемента.
                                                     Если индекс не указан, то объект добавляется в конец списка.

            2. Е get(int индекс)                   - возвращает объект, хранящийся в  списке по указанному индексу.

            3. int indexOf(E объект)               - возвращает индекс первого экземпляра заданного объекта в списке.
                                                     Если этот объект отсутствует в списке, то возвращается -1.

            4. int lastIndexOf(E объект)           - возвращает индекс последнего экземпляра заданного объекта в списке.
                                                     Если этот объект отсутствует в списке, то возвращается  -1.

            5. Е remove(int индекс)                - удаляет элемент из списка по указанному индексу и возвращает удаленный элемент.
                                                     Результирующий список уплотняется, т.е. элементы, следующие за удаленным,
                                                     смещаются на одну позицию назад.

            6. Е set(int индекс, Е oбъект)         - присваивает заданный объект элементу, находящемуся в списке на позиции
                                                     по указанному индексу. Возвращает прежнее значение элемента.

            7. int size()                          - возвращает количество элементов, содержащихся в коллекции.

            8. boolean isEmpty()                   - возвращает true, если список пуст.

            9. void trimToSize()                   - уменьшает емкость до текущего размера списка.




    пример вывода ArrayList

                for (Integer item : list) {
                    System.out.print(item + " ");
                }



                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }



    Элементы ArrayList можно упорядочивать, используя статический метод sort() класса Collections,
    аналогичный методу sort() класса Arrays.

                 Collections.sort(list);


*/
package a2_OOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class a14_jeneric {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(); //создание списка чисел
        System.out.println("Вводите каждое число с новой строки . Для завершения ввода наберите end");
        while (true) {
            try {
                String buffer = scan.nextLine();
                if ("end".equals(buffer)) break; //выход из цикла
                int number = Integer.parseInt(buffer);
                if (number % 2 == 0) { //если четное
                    list.add(number); //происходит автоупаковка, добавляем в конец
                } else { //нечетное
                    list.add(0, number); //добавляем в начало списка
                }
            } catch (NumberFormatException ex) {
                System.out.println("Неверный формат числа");
                // пропускаем неверное число
            }
        }
        System.out.println(list);

        // пример вывода ArrayList
        for (Integer item : list) {
            System.out.print(item + " ");
        }

        // пример вывода ArrayList
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }


        Collections.sort(list);

    }
}



