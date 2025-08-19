/*


Стандартные интерфейсы

    Интерфейс Iterable<T>

        - позволяет использовать класс, который его реализует, в цикле for-each

        - Iterator<T> iterator() - возвращает объект типа Iterator, который будет служить для
                                   выбора элемента из класса объекта.

        - Реализация интерфеса Iterable лишь говорит о том, что объект класса может быть
          "итерирован", т.е. его составные части можно перебрать циклом for-each.
          А за то, как это сделать - отвечает интерфейс Iterator<T>





    Интерфейс Iterator<T>

        - boolean hasNext() - возвращает true, если есть еще элементы для выбора.
                              В противном случае возвращает false.

        - <T> next() - возвращает следующий элемент.
                       Генерирует исключение типа NoSuchElementException, если нет следующего элемента.

        - Когда объект с реализованным интерфейсом Iterable используется в цикле for-each,
          выполняются скрытые вызовы методов hasNext() и next().

*/
package a2_OOP;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class a18_iterator {
    public static void main(String[] args) {
        String str = "Hello, world!";
        StringIterable text = new StringIterable(str);
        for (Character simb : text) {
            System.out.println(simb);
        }
    }
}


class StringIterable implements Iterable<Character> {
    private String str;

    public StringIterable(String str) {
        this.str = str;
    }

    @Override
    public Iterator<Character> iterator() {
        return new StringIterator();
    }

    private class StringIterator implements Iterator<Character> {
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < str.length();
        }

        @Override
        public Character next() {
            if (!hasNext()) throw new NoSuchElementException();
            return str.charAt(count++);
        }
    }
}




/*
    Можно использовать несколько классов итераторов для разных способов переборов.
    Eсли у нас будет один способ перебора, то можно нтерфейсы Iterable и Iterator реализовать в одном классе:


                class StringIterable implements Iterable<Character>, Iterator<Character> {
                    private String str;
                    private int count;

                    public StringIterable(String str) {
                        this.str = str;
                        count = str.length() - 1;
                    }

                    @Override
                    public Iterator<Character> iterator() {
                        return this;
                    }

                    @Override
                    public boolean hasNext() {
                        return count >=0;
                    }

                    @Override
                    public Character next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        return str.charAt(count--);
                    }
                }

*/